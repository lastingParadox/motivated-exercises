/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution 10
 *  Copyright 2021 Zander Preston
 */

package exercises.base;

/*
 Write an application
     Create constant int 'NUMITEMS' = 3, constant double 'TAXRATE' 0.055.
     Create double variable 'subtotal'.
        Set to zero at first.
     Loop for the quantity of items to be purchased:
        If the user does not input a feasible price or quantity:
            Output that the input was invalid and store the new input. Repeat if necessary.
        Prompt the user for the price of item # (# = loop iteration number).
            Stored in double 'price'.
        Prompt the user for the quantity of item #.
            Stored in int 'quantity'.
        'subtotal' += (price*quantity)
     Calculate tax:
        'tax' = 'subtotal' * 0.055.
     Calculate total:
        'total' = 'subtotal' + 'tax'.
     Output the subtotal, tax, and total.
 */

import java.util.Scanner;

public class Solution10 {

    private static final int NUMITEMS = 3;
    private static final double TAXRATE = 0.055;
    private static final Scanner input = new Scanner(System.in);

    public double priceLoop() {
        String response = input.nextLine();
        while (true) {
            try {
                return Double.parseDouble(response);
            }
            catch (NumberFormatException e) {
                System.out.printf("%s is not a valid price. Please enter a value: ", response);
                response = input.nextLine();
            }
        }
    }

    public int quantityLoop() {
        String response = input.nextLine();
        while (true) {
            try {
                return Integer.parseInt(response);
            }
            catch (NumberFormatException e) {
                System.out.printf("%s is not a quantity of items. Please enter a whole number: ", response);
                response = input.nextLine();
            }
        }
    }

    public double startCheckout() {

        int quantity;
        double price;
        double subtotal = 0;

        for (int i = 0; i < NUMITEMS; i++) {
            System.out.printf("Enter the price of item %d: ", i+1);
            price = priceLoop();

            System.out.printf("Enter the quantity of item %d: ", i+1);
            quantity = quantityLoop();

            subtotal += (price*quantity);
        }

        return subtotal;
    }

    public double calculateTax(double subtotal) {
        return subtotal * TAXRATE;
    }

    public double calculateTotal(double subtotal, double tax) {
        return subtotal + tax;
    }

    public static void main(String[] arg) {

        Solution10 cashier = new Solution10();

        double subtotal = cashier.startCheckout();
        double tax = cashier.calculateTax(subtotal);
        double total = cashier.calculateTotal(subtotal, tax);

        System.out.printf("Subtotal: $%.2f%nTax: $%.2f%nTotal: $%.2f", subtotal, tax, total);

    }
}
