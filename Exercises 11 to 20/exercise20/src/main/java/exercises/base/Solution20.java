/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution 20
 *  Copyright 2021 Zander Preston
 */

package exercises.base;

/*
 Write an application.
    Create new Stringbuilder() 'output'.
    Prompt the user for the order amount and which state they live in.
        BigDecimal 'orderAmt' and String 'state'.
        While the user does not input a numerical value:
            Output that the user did not input a numerical value and store a new input. Repeat if necessary.
        BigDecimal 'tax' = 0
        If 'state' = "Wisconsin" or 'state' = 'Illinois":
            If 'state' = "Wisconsin":
                'tax' = 0.05
                Prompt the user which county they live in.
                    If "Dunn":
                        'tax' += 0.004
                    If "Eau Claire":
                        'tax' += 0.006
                'tax' = 'tax' * 'orderAmt'
            Else:
                'tax' = 0.08
                'tax' = 'tax' * 'orderAmt'
            Append "The tax is $'tax'." to 'output'.
    'total' = 'orderAmt' + 'tax'
    Append "The total is $'total'." to 'output'.
    Output 'output'
 */

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Solution20 {

    private static final StringBuilder output = new StringBuilder();
    private static final Scanner input = new Scanner(System.in);

    public BigDecimal wisconsinMatrix(BigDecimal orderAmt, BigDecimal tax) {
        tax = tax.add(BigDecimal.valueOf(0.05));
        System.out.print("What county do you live in? ");
        String county = input.nextLine().toLowerCase();

        if (county.equals("dunn"))
            tax = tax.add(BigDecimal.valueOf(0.004));
        else if (county.equals("eau claire"))
            tax = tax.add(BigDecimal.valueOf(0.005));

        return tax.multiply(orderAmt);
    }

    public double numericalLoop() {
        String response = input.nextLine();
        while (true) {
            try {
                return Double.parseDouble(response);
            }
            catch (NumberFormatException e) {
                System.out.printf("%s is not a number. Please enter a value: ", response);
                response = input.nextLine();
            }
        }
    }

    public static void main(String[] arg) {

        Solution20 calculator = new Solution20();

        System.out.print("What is the order amount? ");
        BigDecimal orderAmt = BigDecimal.valueOf(calculator.numericalLoop());

        System.out.print("What state do you live in? ");
        String state = input.nextLine().toLowerCase();

        BigDecimal tax = BigDecimal.valueOf(0);

        if (state.equals("wisconsin") || state.equals("illinois")) {
            if (state.equals("wisconsin"))
                tax = calculator.wisconsinMatrix(orderAmt, tax);
            else {
                tax = tax.add(BigDecimal.valueOf(0.08));
                tax = tax.multiply(orderAmt);
            }
            output.append(String.format("The tax is $%s.%n", tax.setScale(2, RoundingMode.UP)));
        }

        BigDecimal total = orderAmt.add(tax);
        output.append(String.format("The total is $%s.", total.setScale(2, RoundingMode.UP)));

        System.out.println(output);
    }

}
