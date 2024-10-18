package org.ulpgc.is1.model;

import java.time.LocalDate;

public class Product {
    public final int id;
    private String name;
    private String description;
    private int price;
    private ProductCategory category;
    private Discount discount;
    private Purchase purchase;

    public Product(int id, String name, String description, int price, ProductCategory category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public void setDiscount(LocalDate from, LocalDate to, int percentage){
        this.discount = new Discount(from, to, percentage);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public Discount getDiscount() {
        return discount;
    }

    public Purchase getPurchase() {
        return purchase;
    }
}
