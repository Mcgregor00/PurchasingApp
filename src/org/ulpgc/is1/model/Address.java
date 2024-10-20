package org.ulpgc.is1.model;

public class Address {
    private String street;
    private int number;
    private int postalCode;
    private String city;

    public Address(String street, int postalCode, int number, String city) {
        this.street = street;
        this.postalCode = postalCode;
        this.number = number;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", number=" + number +
                ", postalCode=" + postalCode +
                ", city='" + city + '\'' +
                '}';
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
