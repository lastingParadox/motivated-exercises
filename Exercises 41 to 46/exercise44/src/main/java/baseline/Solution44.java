/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Zander Preston
 */

package baseline;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

public class Solution44 {

    private static final Scanner input = new Scanner(System.in);

    public ProductList createProductList(File inputFile) {
        //Creates a class containing all the items in exercise44_input.json
        Gson gson = new Gson();
        ProductList products = new ProductList(null);

        try (Reader reader = new FileReader(inputFile)) {
            products = gson.fromJson(reader, ProductList.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return products;
    }

    private String promptUser() {
        //Prompts the user to enter the product name.
        System.out.print("What is the product name? ");
        return input.nextLine();
    }

    public Item getListItem(ProductList products, String response) {
        //Validates that the user's input was an item and returns the item.
        //If not, tells the user to enter an item.
        Item temp = null;
        while(true) {
            for (Item item : products.getItems()) {
                if (response.equalsIgnoreCase(item.getName())) {
                    temp = item;
                    break;
                }
            }

            if (temp != null)
                break;
            else {
                System.out.println("Sorry that product was not found in our inventory.");
                response = promptUser();
            }
        }

        return temp;
    }

    public static void main(String[] arg) {
        //Creates a product list from the products in exercise44_input.txt
        //Prompts the user to input a product name and returns the info associated with the item.
        Solution44 prompter = new Solution44();
        ProductList products = prompter.createProductList(new File("./data/exercise44_input.json"));

        String response = prompter.promptUser();
        Item chosenItem = prompter.getListItem(products, response);

        System.out.print(chosenItem);
    }

}
