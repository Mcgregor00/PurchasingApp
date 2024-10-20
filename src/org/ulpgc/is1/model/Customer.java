package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Customer {
    private List<Address> deliveryAddresses;
    private Email email;
    private List<Purchase> purchases;
    private String name;
    private String surname;

    public Customer(String name, String surname, Email email) {
        this.name = name;
        this.surname = surname;
        this.email= email;
        this.deliveryAddresses = new ArrayList<Address>();
        this.purchases = new ArrayList<Purchase>();
    }

    public List<Address> getDeliveryAddresses() {
        return deliveryAddresses;
    }

    public void addDeliveryAddress(String street, int postalCode, int number, String city) {
        deliveryAddresses.add(new Address(street, postalCode, number, city));
    }

    public String getAllName(){
        return name + " " + surname;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(name, customer.name) && Objects.equals(surname, customer.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }
}
