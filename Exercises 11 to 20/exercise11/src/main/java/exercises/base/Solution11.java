/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution 11
 *  Copyright 2021 Zander Preston
 */

package exercises.base;

/*
 Write an application
    Prompt the user how many euros to exchange
        double 'euros'
    Prompt the user the exchange rate of euros to us dollars
        double 'rate'
    If the user did not input a valid number of euros or exchange rate:
        Output that the user did not input a valid value and store the next input. Repeat if necessary.
    Calculate the exchange from euros to us dollars
        'euros' * 'rate' = 'dollars'
        Make sure that dollars is rounded up to the next penny (i.e., if 'dollars' = 1.345, use '1.35')
    Output "'euros' euros at an exchange rate of 'rate' is 'dollars' U.S. dollars."
 */

import java.util.Scanner;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Solution11 {

    private static final Scanner input = new Scanner(System.in);

    public double calcExchange(double euros, double rate) {
        return euros * rate;
    }

    public void printOutput(double euros, double rate, double dollars) {
        DecimalFormat decimal = new DecimalFormat(("0.00"));
        decimal.setRoundingMode(RoundingMode.UP);

        System.out.printf("%.2f euros at an exchange rate of %.4f is%n%s U.S. dollars.", euros, rate,
                           decimal.format(dollars));
    }

    public double numericalLoop() {
        String response = input.nextLine();
        while (true) {
            try {
                return Double.parseDouble(response);
            }
            catch (NumberFormatException e) {
                System.out.printf("%s is not a valid input. Please enter a number: ", response);
                response = input.nextLine();
            }
        }
    }

    public static void main(String[] arg) {

        Solution11 exchanger = new Solution11();

        System.out.print("How many euros are you exchanging? ");
        double euros = exchanger.numericalLoop();

        System.out.print("What is the exchange rate? ");
        double rate = exchanger.numericalLoop();


        double dollars = exchanger.calcExchange(euros, rate);

        exchanger.printOutput(euros, rate, dollars);
    }
}
