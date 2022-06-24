package com.card;

import java.util.ArrayList;
import java.util.List;

public class CardUtility {
    public static List<Card> cardList = new ArrayList<>();

    public static void addProductToCard(Card card) {
        //check if card list already contains a card object with the specific productId and customerId
        //if yes, then update the qty of the existing object, with the qty chosen for the latest card object
        //if not then add the new card object to the list

        int index = -1;
        Card temp = null;

        //if card object is exist in cardList
        for (Card c : cardList) {
            index++;
            if (c.getCustomerId().equals(card.getCustomerId()) && c.getProductId().equals(card.getProductId())) {
                temp = c;
                break;
            }
        }

        if (temp == null) {
            cardList.add(card);
            System.out.println("\nCard Added...");
        } else {
            temp.setQuantity(temp.getQuantity() + card.getQuantity());
            cardList.set(index, temp);
            System.out.println("\nCard updated...");
        }

        //Decrease Stock for the particular productId, that is added to card
        //we need to find the Product object from productList
        //based on the productId that is added to the card

        Product p = ProductUtility.findProduct(card.getProductId());

        //we should decrease the quantity on the p object
        p.setStock(p.getStock() - card.getQuantity());
    }
}
