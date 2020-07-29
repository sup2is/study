package me.sup2is;

public class OrderDto {

    private String customerName;
    private String shippingStreetAddress;
    private String shippingCity;
    private String billingStreetAddress;
    private String billingCity;

    public OrderDto() {
    }

    public OrderDto(String customerName, String shippingStreetAddress, String shippingCity, String billingStreetAddress, String billingCity) {
        this.customerName = customerName;
        this.shippingStreetAddress = shippingStreetAddress;
        this.shippingCity = shippingCity;
        this.billingStreetAddress = billingStreetAddress;
        this.billingCity = billingCity;
    }

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