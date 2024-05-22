//package com.flowershop.flowershop.service;
//
//import com.flowershop.flowershop.entity.Customer;
//import com.shippo.exception.APIConnectionException;
//import com.shippo.exception.APIException;
//import com.shippo.exception.AuthenticationException;
//import com.shippo.exception.InvalidRequestException;
//import com.shippo.model.Address;
//import com.shippo.model.Parcel;
//import com.shippo.model.Shipment;
//import org.springframework.stereotype.Service;
//
//import java.util.HashMap;
//
//@Service
//public class ShippingService {
//    public Address createAddress(com.flowershop.flowershop.entity.Address myAddress, Customer customer) throws APIConnectionException, APIException, AuthenticationException, InvalidRequestException {
//        HashMap<String, Object> addressMap = new HashMap<String, Object>();
//        addressMap.put("name", customer.getFullName());
//        addressMap.put("company", "personal");
//        addressMap.put("street1", myAddress.getStreet());
//        addressMap.put("city", myAddress.getCity());
//        addressMap.put("state", myAddress.getState());
//        addressMap.put("zip", myAddress.getZipCode());
//        addressMap.put("country", "US");
//
//        return Address.create(addressMap);
//    }
//    public Parcel createParcel(double pounds) throws APIConnectionException, APIException, AuthenticationException, InvalidRequestException {
//        HashMap<String, Object> parcelMap = new HashMap<String, Object>();
//        parcelMap.put("length", "11");
//        parcelMap.put("width", "5");
//        parcelMap.put("height", "15");
//        parcelMap.put("distance_unit", "in");
//        parcelMap.put("weight", pounds);
//        parcelMap.put("mass_unit", "lb");
//        return Parcel.create(parcelMap);
//    }
//
//    public Shipment createShipment(Address addressTo, Address addressFrom, Parcel parcel) throws APIConnectionException, APIException, AuthenticationException, InvalidRequestException {
//        HashMap<String, Object> shipmentMap = new HashMap<String, Object>();
//        shipmentMap.put("address_to", addressTo);
//        shipmentMap.put("address_from", addressFrom);
//        shipmentMap.put("parcels", parcel);
//        shipmentMap.put("async", false);
//        return Shipment.create(shipmentMap);
//    }
//
//}
