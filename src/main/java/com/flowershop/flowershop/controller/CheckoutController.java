package com.flowershop.flowershop.controller;


import com.flowershop.flowershop.dto.PaymentInfo;
import com.flowershop.flowershop.dto.Purchase;
import com.flowershop.flowershop.dto.PurchaseResponse;
import com.flowershop.flowershop.service.CheckoutService;
//import com.flowershop.flowershop.service.ShippingService;
//import com.shippo.exception.APIConnectionException;
//import com.shippo.exception.APIException;
//import com.shippo.exception.AuthenticationException;
//import com.shippo.exception.InvalidRequestException;
//import com.shippo.model.Address;
//import com.shippo.model.Parcel;
//import com.shippo.model.Shipment;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    private CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {

        PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);

        return purchaseResponse;
    }
    @PostMapping("/payment-intent")
    public ResponseEntity<String> createPaymentIntent(@RequestBody PaymentInfo paymentInfo) throws StripeException {

        PaymentIntent paymentIntent = checkoutService.createPaymentIntent(paymentInfo);
        String paymentStr = paymentIntent.toJson();

        return new ResponseEntity<>(paymentStr, HttpStatus.OK);
    }
//    @PostMapping("/shippo")
//    public ResponseEntity<String> createAddress(@RequestBody PaymentInfo paymentInfo) throws APIConnectionException, APIException, AuthenticationException, InvalidRequestException {
//
//        Address address = checkoutService.createAddress();
//
//        return new ResponseEntity<>(address.toString(), HttpStatus.OK);
//    }
//    @PostMapping("/shipping-rates")
//    public ResponseEntity<Shipment> getShippingRates(@RequestBody Purchase purchase) throws APIConnectionException, APIException, AuthenticationException, InvalidRequestException {
//        Address myAddress = new Address();
//        myAddress.setCountry("US");
//        myAddress.setState("NC");
//        myAddress.setCountry("US");
//        myAddress.setCity("greensboro");
//        myAddress.setZip("US");
//        myAddress.setStreet1("631 Lantern Ridge Dr");
//        myAddress.setName("kay kay");
//        Address addressTo = shippingService.createAddress(purchase.getShippingAddress(), purchase.getCustomer());
//
//        Parcel pac = shippingService.createParcel(4);
//        Shipment rates = shippingService.createShipment(addressTo, myAddress, pac);
//       return new ResponseEntity<>(rates, HttpStatus.OK);
//    }

}









