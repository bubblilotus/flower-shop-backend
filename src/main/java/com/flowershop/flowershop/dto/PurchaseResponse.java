package com.flowershop.flowershop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class PurchaseResponse {

    private final String orderTrackingNumber;

    public PurchaseResponse(String orderTrackingNumber) {
        this.orderTrackingNumber = orderTrackingNumber;
    }
}
