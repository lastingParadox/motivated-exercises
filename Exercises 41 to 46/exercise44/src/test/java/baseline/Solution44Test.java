/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Zander Preston
 */

package baseline;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class Solution44Test {

    Solution44 test = new Solution44();

    @Test
    void createProductListTest() {
        //Verifies that a class containing the items is correctly given from exercise44_input.txt
        ProductList actualList = test.createProductList(new File("./data/test.json"));
        String actual = actualList.toString();
        String expected = String.format("Name: Widget%nPrice: 25.00%nQuantity: 5%n" +
                                        "Name: Thing%nPrice: 15.00%nQuantity: 5%n" +
                                        "Name: Doodad%nPrice: 5.00%nQuantity: 10%n");

        assertEquals(expected, actual);
    }

    @Test
    void getListItemTest() {
        //Compares the item gotten from the getListItem() method with a manually assigned item.
        ProductList products = test.createProductList(new File("./data/test.json"));

        String response = "Widget";

        Item expected = new Item("Widget", 25.00, 5);
        Item actual = test.getListItem(products, response);

        assertEquals(expected.toString(), actual.toString());
    }

}