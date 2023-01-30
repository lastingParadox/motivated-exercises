/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution 12
 *  Copyright 2021 Zander Preston
 */

package exercises.base;

/*
 Write an application.
    Prompt the user for the principal amount, the rate of interest, and the time.
        Double variables: 'principal', 'rate', 'time'.
        If the user did not enter a number for any of these values:
            Output that the input was invalid and store the next input. Repeat if necessary.
        Divide rate by 100 for computation, as the user will input the rate percentage.
    Calculate the simple interest using the formula A = 'principal'(1 + 'rate' * 'time').
        Function 'calcInterest()', double variable 'finalAmt'
    Output "After 'time' years at 'rate*100'%, the investment will be worth $'finalAmt'.".
        Make sure that finalAmt is rounded up to the next penny (i.e., if 'finalAmt' = 1.345, use 1.35).
 */

import java.util.Scanner;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Solution12 {

    private static final Scanner input = new Scanner(System.in);

    public double calcInterest(double principal, double rate, double time) {
        return principal*(1 + rate * time);
    }

    public void printOutput(double time, double rate, double finalAmt) {
        DecimalFormat decimal = new DecimalFormat(("0.00"));
        decimal.setRoundingMode(RoundingMode.UP);

        System.out.printf("After %.2f years at %.2f%%, the investment will be worth $%s.", time, rate*100,
                           decimal.format(finalAmt));
    }

    public double numericalLoop() {
        String response = input.nextLine();
        while (true) {
            try {
                return Double.parseDouble(response);
            }
            catch (NumberFormatException e) {
                System.out.printf("%s is not a numerical value. Please enter a number: ", response);
                response = input.nextLine();
            }
        }
    }

    public static void main(String[] arg) {

        Solution12 calculator = new Solution12();

        System.out.print("Enter the principal: ");
        double principal = calculator.numericalLoop();

        System.out.print("Enter the rate of interest: ");
        double rate = calculator.numericalLoop();
        rate /= 100;

        System.out.print("Enter the number of years: ");
        double time = calculator.numericalLoop();

        double finalAmt = calculator.calcInterest(principal, rate, time);
        calculator.printOutput(time, rate, finalAmt);
    }
}
