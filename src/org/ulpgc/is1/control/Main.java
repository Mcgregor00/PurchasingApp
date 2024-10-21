package org.ulpgc.is1.control;

import org.ulpgc.is1.model.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        PurchasingManager purchasingManager = new PurchasingManager();

        //First person, Pedro Sanchez is added
        purchasingManager.addCustomer("Pedro", "Sanchez", "PedroSanchez@hotmail.com");
        purchasingManager.getCustomer("Pedro", "Sanchez", "PedroSanchez@hotmail.com").addDeliveryAddress("Goya", 35109, 23, "Las Palmas");

        //Second person, Lola Lolita is added
        purchasingManager.addCustomer("Lola", "Lolita", "LolaLolita@gmail.com");
        purchasingManager.getCustomer("Lola", "Lolita", "LolaLolita@gmail.com").addDeliveryAddress("Malasaña", 32250, 32, "Valencia");

        //Pedro Sanchez is added again, but it is already added
        purchasingManager.addCustomer("Pedro", "Sanchez", "PedroSanchez@hotmail.com");

        //First product, bible
        purchasingManager.addProduct(1, "Bible", "The sacred writings", 12, ProductCategory.Book);

        //Add a product already added
        purchasingManager.addProduct(1, "Bible", "The sacred writings", 12, ProductCategory.Book);

        //Second product, Nerf, with discount
        purchasingManager.addProduct(5, "Nerf", "Toy gun for kids", 50, ProductCategory.Toy);
        purchasingManager.getProduct(5).setDiscount(LocalDate.of(2024, 10, 19), LocalDate.of(2024, 10, 31), 80);

        //Luis buy 2 products
        purchasingManager.purchase("Pedro", "Sanchez", "PedroSanchez@hotmail.com", 1, 1);
        purchasingManager.purchase("Pedro", "Sanchez", "PedroSanchez@hotmail.com", 5, 1);
        purchasingManager.getCustomer("Pedro", "Sanchez", "PedroSanchez@hotmail.com").getPurchase(2).setPayment("4020 4583 5493 0770");

        //Buy of first Customer, product 2
        purchasingManager.customerData(purchasingManager.getCustomer("Pedro", "Sanchez", "PedroSanchez@hotmail.com"));

    }
}
