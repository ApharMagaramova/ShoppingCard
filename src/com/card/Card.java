package com.card;

import java.util.Objects;

public class Card {
    private String customerId;
    private String productId;
    private int price;
    private int quantity;

    public Card() {
        super();
    }

    public Card(String customerId, String productId, int price, int quantity) {
        this.customerId = customerId;
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return price == card.price && quantity == card.quantity && customerId.equals(card.customerId) && productId.equals(card.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, productId, price, quantity);
    }
}
