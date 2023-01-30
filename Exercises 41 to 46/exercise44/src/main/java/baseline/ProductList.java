/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Zander Preston
 */

package baseline;

public class ProductList {

    private final Item[] products;

    ProductList(Item[] products) {
        //ProductList Constructor
        this.products = products;
    }

    public Item[] getItems() {
        //Returns the product list.
        return products;
    }

    @Override
    public String toString() {
        //Used in testing that the product object is filled
        StringBuilder temp = new StringBuilder();

        for (Item item : products) {
            temp.append(item.toString());
        }

        return String.valueOf(temp);
    }
}
