package org.ulpgc.is1.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    public List<Customer> getCustomers() {
        return customers;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void customerData(Customer customer) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        StringBuilder sb = new StringBuilder();

        sb.append("\nEl cliente ").append(customer.getName()).append(" tiene ")
                .append(customer.getPurchases().size()).append(" reservas\n\n")
                .append("===========================================================\n")
                .append("\tCompras de ").append(customer.getAllName()).append("\n");

        String emailStatus = customer.getEmail().isValid() ? "Valido" : "Invalido, cambie el Email por favor";
        sb.append("\t--Email: ").append(customer.getEmail().getAccount()).append(" (").append(emailStatus).append(")\n")
                .append("===========================================================\n\n");

        for (Purchase purchase : customer.getPurchases()) {
            sb.append("_______________________________________________\n")
                    .append("Compra ").append(purchase.getId()).append("\n")
                    .append("················································\n")
                    .append("\t| Datos de la compra: |\n")
                    .append("\t\t--Código de la compra: ").append(purchase.getId()).append("\n")
                    .append("\t\t--Fecha de la compra: ").append(purchase.getDate().format(formatter)).append("\n")
                    .append("\t\t--Direccion: ").append(purchase.getAddress()).append("\n");

            if (purchase.isPaid()) {
                sb.append("\t\t--Compra pagada\n")
                        .append("\t\t\t> Card: ").append(purchase.getPayment().getCard()).append("\n")
                        .append("\t\t\t> Cantidad: ").append(purchase.getPayment().getAmount()).append("\n")
                        .append("\t\t\t> Fecha de pago: ").append(purchase.getPayment().getDate().format(formatter)).append("\n");
            } else {
                sb.append("\t\t--Compra no pagada\n");
            }

            sb.append("\t| Datos del producto: |\n")
                    .append("\t\t--Código: ").append(purchase.getProduct().id).append("\n")
                    .append("\t\t--Nombre: ").append(purchase.getProduct().getName()).append("\n")
                    .append("\t\t--Descripción: ").append(purchase.getProduct().getDescription()).append("\n")
                    .append("\t\t--Categoria: ").append(purchase.getProduct().getCategory()).append("\n")
                    .append("\t\t--Precio: ").append(purchase.getProduct().getPrice()).append("\n");

            Discount discount = purchase.getProduct().getDiscount();
            if (discount != null && discount.isValid()) {
                sb.append("\t\t--Con descuento:\n")
                        .append("\t\t\t> Porcentaje: ").append(discount.getPercentage() * 100).append("%\n")
                        .append("\t\t\t> Desde: ").append(discount.getFrom().format(formatter)).append("\n")
                        .append("\t\t\t> Hasta: ").append(discount.getTo().format(formatter)).append("\n");
            } else {
                sb.append("\t\t--Sin descuento por el momento\n");
            }

            sb.append("\t--TOTAL: ").append(purchase.price()).append("\n")
                    .append("_______________________________________________\n\n");
        }

        System.out.println(sb.toString());
    }

}


