/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Zander Preston
 */

package baseline;

import java.util.Scanner;

//Exercise 26 - Months to Pay Off a Credit Card
//  Using the user's balance, APR, and monthly payments, returns how many months it will take to pay off the card.

public class Solution26 {

    static final Scanner input = new Scanner(System.in);

    private String storeInput(String prompt) {
        //Prompts the user for an input and returns it.
        System.out.print(prompt);
        return input.nextLine();
    }

    private double validateResponse(String prompt) {
        //Takes in the user's response and validates if it is a number. If not, prompts the user to enter a number.
        String response = storeInput(prompt);
        while(true) {
            try {
                return Double.parseDouble(response);
            }
            //If the user's response is not a number, skips the error and prompts the user to enter a number.
            catch (NumberFormatException e) {
                System.out.printf("%s is not a number. Please enter a value: ", response);
                response = input.nextLine();
            }
        }
    }

    public static void main(String[] arg) {
        //Prompts the user to enter information regarding their card debt
        //  Returns the number of months they need to pay it off.

        Solution26 reader = new Solution26();

        //Prompts for balance, apr, and monthly payments with validation to ensure numbers are input.
        double balance = reader.validateResponse("What is your balance? ");
        double apr = reader.validateResponse("What is the APR on the card (as a percent)? ");
        double monthPayment = reader.validateResponse("What is the monthly payment you can make? ");

        PaymentCalculator calculator = new PaymentCalculator(balance, apr, monthPayment);

        //Calculates the number of months needed.
        int months = calculator.calculateMonthsUntilPaidOff();

        System.out.printf("It will take you %d months to pay off this card.", months);

    }

}
