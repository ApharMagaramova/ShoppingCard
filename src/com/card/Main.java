package com.card;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static Customer customer = null;
    public static String productId = "";
    public static int quantity = 0;

    public static void main(String[] args) {
        int choice = 0;
        do {
            //here we need to display the product list
            showProducts();
            System.out.println("\n1. Add Product To Card");
            System.out.println("2. View Card Items");
            System.out.println("3. Delete Card");
            System.out.println("4. Exit");

            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (customer == null) {
                        readCustomerDetails();
                    }
                    showProducts();
                    readProductDetails();
                    createCardAndAddToCardList();
                    break;
                case 2:
                    viewCardItems();
                    break;
                case 3:
                    deleteCard();
                    break;
                default:
                    System.out.println("Thank you!");
            }

        } while (choice < 4 && choice > 0);
    }

    private static void createCardAndAddToCardList() {
        Card card = new Card(customer.getCustomerId(), productId, ProductUtility.getProductPrice(productId), quantity);
        CardUtility.addProductToCard(card);
    }

    private static void readProductDetails() {
        System.out.println("Enter the product id: ");
        productId = scanner.next();
        System.out.println("Enter quantity: ");
        quantity = scanner.nextInt();

    }

    private static void readCustomerDetails() {
        customer = new Customer();
        String customerId = "";
        String customerName = "";
        String customerCity = "";

        System.out.println("Enter customer id: ");
        customerId = scanner.next();
        System.out.println("Enter customer name: ");
        customerName = scanner.next();
        System.out.println("Enter customer city: ");
        customerCity = scanner.next();

        customer.setCustomerId(customerId);
        customer.setCustomerName(customerName);
        customer.setCustomerCity(customerCity);
    }

    //the code delete card
    private static void deleteCard() {
        Card temp = null;

        for (Card c : CardUtility.cardList) {
            if (c.getCustomerId().equals(customer.getCustomerCity())) {
                temp = c;
                break;
            }
        }
        CardUtility.cardList.remove(temp);
        System.out.println("Card removed...");
    }


    //the code to show the card items
    private static void viewCardItems() {
        //we need to fetch the cardList from CardUtility
        System.out.println();
        System.out.printf("%-13s%-8s%-12s%-11s", "PRODUCT-NAME", "PRICE", "QUANTITY", "TOTAL PRICE");
        System.out.println("\n-------------------------------------------------------------");
        for (Card c : CardUtility.cardList) {
            //productId, price, qty, price*qty
//            int price=ProductUtility.getProductPrice(c.getProductId());
            String productName = ProductUtility.getProductName(c.getProductId());
            System.out.printf("%-13s%-8s%-12s%-11s", productName, c.getPrice(), c.getQuantity(), (c.getQuantity() * c.getPrice()));
            System.out.println("\n");
        }
        System.out.println();
    }


    public static void showProducts() {
        System.out.printf("%-11s%-15s%-8s%-12s%-8s", "PRODUCT-ID", "PRODUCT-NAME", "PRICE", "CATEGORY", "STOCK");
        System.out.println("\n-------------------------------------------------------------");
        for (Product p : ProductUtility.productList) {
            System.out.printf("%-11s%-15s%-8s%-12s%-8d", p.getProductId(), p.getProductName(),
                    "$" + p.getPrice(), p.getCategory(), p.getStock());
            System.out.println();
        }
    }
}