package com.card;

import java.util.Objects;

public class Customer {
    private String customerId;
    private String customerName;
    private String customerCity;

    public Customer() {
    }

    public Customer(String customerId, String customerName, String customerCity) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerCity = customerCity;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerCity() {
        return customerCity;
    }

    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return customerId.equals(customer.customerId) && customerName.equals(customer.customerName) && customerCity.equals(customer.customerCity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, customerName, customerCity);
    }
}
