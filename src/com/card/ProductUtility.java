package com.card;

import java.util.ArrayList;
import java.util.List;

public class ProductUtility {
    public static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product("P101", "S22 Ultra", "MOBILE", 2000, 20));
        productList.add(new Product("P102", "IPhone 13", "MOBILE", 2100, 25));
        productList.add(new Product("P103", "Google Home", "GADGETS", 100, 30));
        productList.add(new Product("P104", "Bluetooth", "GADGETS", 80, 50));
        productList.add(new Product("P105", "Charger", "MOBILE", 50, 60));

    }

    public static String getProductName(String productId) {
        String productName = "";
        for (Product p : productList) {
            if (p.getProductId().equals(productId)) {
                productName = p.getProductName();
                break;
            }
        }
        return productName;
    }

    public static int getProductPrice(String productId) {
        int price = 0;
        for (Product p : productList) {
            if (p.getProductId().equals(productId)) {
                price = p.getPrice();
                break;
            }
        }
        return price;
    }

    public static Product findProduct(String productId) {
        Product temp = null;
        for (Product p : productList) {
            if (p.getProductId().equals(productId)) {
                temp = p;
                break;
            }
        }
        return temp;
    }
}
