package org.ulpgc.is1.model;

import java.time.LocalDate;

public class Purchase {
    private static int NEXT_ID = 0;
    private final int id;
    private LocalDate date;
    private Customer customer;
    private Address address;
    private Product product;

    public Purchase(Customer customer, Product product) {
        this.customer = customer;
        this.product = product;
        this.id = NEXT_ID++;
        this.date = LocalDate.now();
        this.address = customer.getDeliveryAddresses().get(0);
    }

    public float price() {
        if (product.getDiscount() != null && product.getDiscount().isValid()) {
            return product.getPrice() * product.getDiscount().getPercentage();
        }
        return product.getPrice();
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getId() {
        return id;
    }
}
