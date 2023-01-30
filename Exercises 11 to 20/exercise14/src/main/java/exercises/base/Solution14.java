/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution 14
 *  Copyright 2021 Zander Preston
 */

package exercises.base;

/*
 Write an application.
    Constant double 'WITAX' = 0.055.
    Prompt the user for the order amount and the state abbreviation.
        Double 'amount' and string 'state'.
        If the user does not input a number for 'amount':
            Output that the user did not input a valid value and store the next input. Repeat if applicable.
    Double 'total' = 'amount'.
    String output as a "StringBuilder".
        If 'state' = "WI":
            double tax = 'amount' * 'WITAX'.
            double total += 'tax'.
            Append to 'output': "The subtotal is $'amount'.%nThe tax is 'tax'.%n"
    Append to 'output': "The total is $'total'."
    Print output.
 */

import java.math.RoundingMode;
import java.util.Scanner;
import java.math.BigDecimal;

public class Solution14 {
    private static final BigDecimal WITAX = new BigDecimal("0.055");
    private static final Scanner input = new Scanner(System.in);

    public BigDecimal wisconsinTax(BigDecimal total) {
        return total.multiply(WITAX);
    }

    public BigDecimal wisconsinTotal(BigDecimal total, BigDecimal tax) {
        return total.add(tax);
    }

    public double numericalLoop() {
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

    public static void main(String[] arg) {

        Solution14 calculator = new Solution14();

        System.out.print("What is the order amount? ");
        BigDecimal amount = BigDecimal.valueOf(calculator.numericalLoop());
        BigDecimal total = amount;

        System.out.print("What is the state? ");
        String state = input.nextLine().toUpperCase();

        StringBuilder output = new StringBuilder();

        if (state.equals("WI")) {
            BigDecimal tax = calculator.wisconsinTax(total);
            total = calculator.wisconsinTotal(total, tax);

            output.append(String.format("The subtotal is $%s.%nThe tax is $%s.%n",
                                         amount.setScale(2, RoundingMode.UP),
                                         tax.setScale(2, RoundingMode.UP)));
        }

        output.append(String.format("The total is $%s.", total.setScale(2, RoundingMode.UP)));

        System.out.println(output);
    }
}
