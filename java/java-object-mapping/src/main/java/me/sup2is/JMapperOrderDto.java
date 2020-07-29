package me.sup2is;

import com.googlecode.jmapper.annotations.JMap;

public class JMapperOrderDto {

    @JMap("${customer.name}")
    private String customerName;
    @JMap("${shippingAddress.street}")
    private String shippingStreetAddress;
    @JMap("${shippingAddress.city}")
    private String shippingCity;
    @JMap("${billingAddress.street}")
    private String billingStreetAddress;
    @JMap("${billingAddress.city}")
    private String billingCity;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getShippingStreetAddress() {
        return shippingStreetAddress;
    }

    public void setShippingStreetAddress(String shippingStreetAddress) {
        this.shippingStreetAddress = shippingStreetAddress;
    }

    public String getShippingCity() {
        return shippingCity;
    }

    public void setShippingCity(String shippingCity) {
        this.shippingCity = shippingCity;
    }

    public String getBillingStreetAddress() {
        return billingStreetAddress;
    }

    public void setBillingStreetAddress(String billingStreetAddress) {
        this.billingStreetAddress = billingStreetAddress;
    }

    public String getBillingCity() {
        return billingCity;
    }

    public void setBillingCity(String billingCity) {
        this.billingCity = billingCity;
    }
}