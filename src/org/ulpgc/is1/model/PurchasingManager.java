package org.ulpgc.is1.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PurchasingManager {
    private List<Customer> customers;
    private List<Product> products;
    //private List<Purchase> purchases;

    public PurchasingManager() {
        customers = new ArrayList<Customer>();
        products = new ArrayList<Product>();
    }

    public void addCustomer(String name, String surname, String account) {
        Customer customer = new Customer(name, surname, account);
        if (customers.contains(customer)) {
            System.out.println("This customer already exists");
        } else {
            customers.add(customer);
            System.out.println("Customer added");
        }
    }

    public Customer getCustomer(String name, String surname, String account) {
        for (Customer customer : customers) {
            if (name.equals(customer.getName()) && surname.equals(customer.getSurname()) && account.equals(customer.getEmail().getAccount())) {
                return customer;
            }
        }
        System.out.println("Customer not found");
        return null;
    }

    public void addProduct(int id, String name, String description, int price, ProductCategory category) {
        Product product = new Product(id, name, description, price, category);
        if (!products.contains(product)) {
            products.add(product);
            System.out.println("Product added");
        } else {
            System.out.println("This product already exists");
        }
    }

    public Product getProduct(int id) {
        for (Product product : products) {
            if (id == product.getId()) {
                return product;
            }
        }
        System.out.println("Product not found");
        return null;
    }

    public void purchase(String name, String surname, String account, int id, int numAddress) {
        Customer customer = getCustomer(name, surname, account);
        Product product = getProduct(id);
        Purchase purchase = new Purchase(customer, product, numAddress);
        customer.addPurchase(purchase);
        if (product.getPurchase() == null) {
            product.setPurchase(purchase);
        } else {
            System.out.println("This product already is associated with a purchase");
        }
    }

    public List<Purchase> getPurchaseList(String name, String surname, String account) {
        return getCustomer(name, surname, account).getPurchases();
    }

    public void data(int numCustomer, int numPurchase) {
        LocalDate currentDate = LocalDate.now();
        Customer customer = customers.get(numCustomer - 1);
        Purchase purchase = customer.getPurchase(numPurchase);
        System.out.println("El cliente " + numCustomer + " tiene " + customer.getPurchases().size() + " compras.");
        System.out.println();
        System.out.println("__________________________________________________________________________________________");
        System.out.println("Nombre: " + customer.getAllName() + ". Con email: " + customer.getEmail().getAccount());
        System.out.println("__________________________________________________________________________________________");
        System.out.println();
        System.out.println("Compra: " + numPurchase);
        System.out.println("-----------------------------");
        System.out.println("-> Datos de la compra: ");
        System.out.println("        - Fecha de la compra: " + currentDate);
        System.out.println("        - Punto de entrega:");
        System.out.println("                Calle: " + purchase.getAddress().getStreet());
        System.out.println("                Número: " + purchase.getAddress().getNumber());
        System.out.println("                Codigo Postál: " + purchase.getAddress().getPostalCode());
        System.out.println("                Ciudad: " + purchase.getAddress().getCity());
        System.out.println("        - Nº Targeta: " + purchase.getPayment().getCard());
        System.out.println("        - Cobro total: " + purchase.price());
        System.out.println("-> Datos del producto: ");
        System.out.println("        - ID del producto: " + purchase.getProduct().getId());
        System.out.println("        - Nombre del producto: " + purchase.getProduct().getName());
        System.out.println("        - Descripcion del producto: " + purchase.getProduct().getDescription());
        System.out.println("        - Categoría del producto: " + purchase.getProduct().getCategory());
        System.out.println("        - Precio del producto: " + purchase.getProduct().getPrice());
        System.out.println("        - Descuento: " + purchase.getProduct().getDiscount().getPercentage()*100 + "%");
        System.out.println("                - Desde el: " + purchase.getProduct().getDiscount().getFrom());
        System.out.println("                - Hasta el: " + purchase.getProduct().getDiscount().getTo());
        System.out.println("        - Total descontado: " + (purchase.getProduct().getPrice() - purchase.price()));
        System.out.println("----------------------------");
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public List<Product> getProducts() {
        return products;
    }
}


