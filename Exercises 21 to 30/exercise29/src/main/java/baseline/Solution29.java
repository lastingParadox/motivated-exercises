/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Zander Preston
 */

package baseline;

import java.util.Scanner;

//Exercise 29 - Handling Bad Input
//  Takes in the user's rate of return and outputs the time (in years) it will take to double the investment.

public class Solution29 {

    private static final Scanner input = new Scanner(System.in);

    private String takeInput() {
        //Prompts the user to enter the rate of return and takes in the input.
        System.out.print("What is the rate of return? ");
        return input.nextLine();
    }

    public double validateDoubleResponse(String response) {
        //Validates whether the response is a nonzero number.
        //If not, prompts the user to enter a number and stores the response.
        double doubleResponse;
        while (true) {
            try {
                doubleResponse = Double.parseDouble(response);

                //Nonzero validation
                while (doubleResponse <= 0) {
                    System.out.println("Please enter a value greater than zero.");
                    response = takeInput();
                    doubleResponse = Double.parseDouble(response);
                }

                return doubleResponse;
            }
            catch (NumberFormatException e) {
                System.out.println("Sorry, that's not a valid input.");
                response = takeInput();
            }
        }
    }

    public double calcDoubleTime (double rate) {
        //Calculates the years it will take to double an initial investment.
        return 72/rate;
    }

    public static void main(String[] arg) {
        //Prompts the user to input a rate of return
        //  Returns the years it will take to double an investment.
        Solution29 calculator = new Solution29();

        String response = calculator.takeInput();
        double rate = calculator.validateDoubleResponse(response);

        System.out.printf("It will take %.2f years to double your initial investment.",
                          calculator.calcDoubleTime(rate));
    }
}
