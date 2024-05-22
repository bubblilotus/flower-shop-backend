package com.flowershop.flowershop.service;


import com.flowershop.flowershop.dto.PaymentInfo;
import com.flowershop.flowershop.dto.Purchase;
import com.flowershop.flowershop.dto.PurchaseResponse;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);

    PaymentIntent createPaymentIntent(PaymentInfo paymentInfo) throws StripeException;

//    public Address createAddress()throws APIConnectionException, APIException, AuthenticationException, InvalidRequestException;
}
