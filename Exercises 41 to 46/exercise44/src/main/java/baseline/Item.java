/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Zander Preston
 */

package baseline;

public class Item {

    private final String name;
    private final double price;
    private final int quantity;

    Item(String name, double price, int quantity) {
        //Item Constructor
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        //Returns the name of the item.
        return name;
    }

    @Override
    public String toString() {
        //Override used in printing the specified item
        return String.format("Name: %s%nPrice: %.2f%nQuantity: %d%n", name, price, quantity);
    }
}
