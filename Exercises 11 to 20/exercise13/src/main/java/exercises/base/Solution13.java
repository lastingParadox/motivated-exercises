/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution 13
 *  Copyright 2021 Zander Preston
 */

package exercises.base;

/*
 Write an application.
    Prompt the user for the principal amount, the rate of interest, and the time.
        double variables: 'principal', 'rate', 'time', 'compound'.
        If the user did not enter a numerical value for any of these prompts:
            Output that the user did not input a correct value and store the next input. Repeat if applicable.
        Divide rate by 100 for computation, as the user will input the rate percentage.
    Calculate the compounded interest using the formula A = 'principal'(1 + 'rate' / 'compound')^('compound' * 'time').
        Use 'principal' * Math.pow((1 + 'rate' / 'compound'), ('compound * 'time').
        Function 'calcInterest()', returns double variable 'finalAmt'.
    Output "$'principal' invested at 'rate*100''% for 'time' years compounded 'compound' times per year is $'finalAmt'.".
        Make sure that finalAmt is rounded up to the next penny (i.e., if 'finalAmt' = 1.345, use 1.35).
*/

import java.util.Scanner;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Solution13 {

    private static final Scanner input = new Scanner(System.in);

    public double calcInterest(double principal, double rate, int compound, int time) {
        return principal * Math.pow((1 + rate/compound), (compound*time));
    }

    public void printOutput(double principal, int time, double rate, int compound, double finalAmt) {
        DecimalFormat decimal = new DecimalFormat(("0.00"));
        decimal.setRoundingMode(RoundingMode.UP);

        System.out.printf("$%.2f invested at %.2f%% for %d years compounded %d times per year is $%s.", principal,
                rate*100, time, compound, decimal.format(finalAmt));
    }

    public double doubleLoop() {
        String response = input.nextLine();
        while (true) {
            try {
                return Double.parseDouble(response);
            }
            catch (NumberFormatException e) {
                System.out.printf("%s is not a valid value. Please enter a number: ", response);
                response = input.nextLine();
            }
        }
    }

    public int integerLoop() {
        String response = input.nextLine();
        while (true) {
            try {
                return Integer.parseInt(response);
            }
            catch (NumberFormatException e) {
                System.out.printf("%s is not a valid value. Please enter an integer: ", response);
                response = input.nextLine();
            }
        }
    }


    public static void main(String[] arg) {

        Solution13 calculator = new Solution13();

        System.out.print("What is the principal amount? ");
        double principal = calculator.doubleLoop();

        System.out.print("What is the rate? ");
        double rate = calculator.doubleLoop();
        rate /= 100;

        System.out.print("What is the number of years? ");
        int time = calculator.integerLoop();

        System.out.print("What is the number of times the interest is compounded per year? ");
        int compound = calculator.integerLoop();

        double finalAmt = calculator.calcInterest(principal, rate, compound, time);
        calculator.printOutput(principal, time, rate, compound, finalAmt);
    }
}
