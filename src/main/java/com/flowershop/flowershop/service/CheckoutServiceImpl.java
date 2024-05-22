package com.flowershop.flowershop.service;

import com.flowershop.flowershop.dao.CustomerRepository;
import com.flowershop.flowershop.dao.RecipientRepository;
import com.flowershop.flowershop.dto.PaymentInfo;
import com.flowershop.flowershop.dto.Purchase;
import com.flowershop.flowershop.dto.PurchaseResponse;
import com.flowershop.flowershop.entity.Customer;
import com.flowershop.flowershop.entity.Order;
import com.flowershop.flowershop.entity.OrderItem;

import com.flowershop.flowershop.entity.Recipient;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private CustomerRepository customerRepository;
    private RecipientRepository recipientRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository,
                               RecipientRepository recipientRepository,
                               @Value("${stripe.key.secret}") String secretKey) {
        this.customerRepository = customerRepository;
        this.recipientRepository = recipientRepository;
        //initalize stripe api with secret key
        Stripe.apiKey = secretKey;
//        Shippo.setApiKey(shippingKey);
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        // retrieve the order info from dto
        Order order = purchase.getOrder();

        // generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        // populate order with orderItems
        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item -> order.add(item));

        // populate order with billingAddress and shippingAddress
        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());

        // populate customer with order
        Customer customer = purchase.getCustomer();
        customer.add(order);

        // save to the database
        customerRepository.save(customer);

        // populate recipient with order
        Recipient recipient = purchase.getRecipient();
        recipient.add(order);

        // save to the database
        recipientRepository.save(recipient);

        // return a response
        return new PurchaseResponse(orderTrackingNumber);
    }

    @Override
    public PaymentIntent createPaymentIntent(PaymentInfo paymentInfo) throws StripeException {
        List<String> paymentMethodTypes = new ArrayList<>();
        paymentMethodTypes.add("card");

        Map<String, Object> params = new HashMap<>();
        params.put("amount", paymentInfo.getAmount());
        params.put("currency", paymentInfo.getCurrency());
        params.put("payment_method_types", paymentMethodTypes);

        return PaymentIntent.create(params);
    }
//    @Override
//    public Address createAddress() throws APIConnectionException, APIException, AuthenticationException, InvalidRequestException {
//        HashMap<String, Object> addressMap = new HashMap<String, Object>();
//        addressMap.put("name", "Mr. Hippo");
//        addressMap.put("company", "Shippo");
//        addressMap.put("street1", "215 Clayton St.");
//        addressMap.put("city", "San Francisco");
//        addressMap.put("state", "CA");
//        addressMap.put("zip", "94117");
//        addressMap.put("country", "US");
//        addressMap.put("phone", "+1 555 341 9393");
//        addressMap.put("email", "support@goshipppo.com");
//
//        return Address.create(addressMap);
//    }
    private String generateOrderTrackingNumber() {

        // generate a random UUID number (UUID version-4)
        // For details see: https://en.wikipedia.org/wiki/Universally_unique_identifier
        //
        return UUID.randomUUID().toString();
    }
}









