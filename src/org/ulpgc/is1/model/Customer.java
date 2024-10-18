package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private List<Address> deliveryAddresses;
    private Email email;
    private List<Purchase> purchases;
    private String name;
    private String surname;

    public Customer(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.deliveryAddresses = new ArrayList<Address>();
        this.purchases = new ArrayList<Purchase>();
    }

    public List<Address> getDeliveryAddresses() {
        return deliveryAddresses;
    }

    public void addDeliveryAddress(String street, int postalCode, int number, String city) {
        deliveryAddresses.add(new Address(street, postalCode, number, city));
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void addPurchase(Purchase purchase) {
        purchases.add(purchase);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
