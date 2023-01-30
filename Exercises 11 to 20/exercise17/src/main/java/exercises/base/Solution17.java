/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution 17
 *  Copyright 2021 Zander Preston
 */

package exercises.base;

/*
 Write an application.
    Constant doubles 'M_ALCOHOL_DIST', 'F_ALCOHOL_DIST', and 'BAC_LIMIT' as 0.73, 0.66, and 0.08
    Prompt the user to enter a 1 or 2:
        Stored in integer 'sex'.
        1 = male, 2 = female.
        If input does not equal 1 or 2:
            Prompt the user to enter a 1 or 2.
        If 'sex' = 1:
            'sex' = 'M_ALCOHOL_DIST'
        Else:
            'sex' = 'F_ALCOHOL_DIST'
    Prompt the user to enter how many ounces of alcohol they drank.
        Stored in integer 'ounces'
        If input does not equal a number:
            Prompt the user to enter a number.
    Prompt the user to enter their weight, in pounds.
        integer 'weight'
        If input does not equal a number:
            Prompt the user to enter a number.
    Prompt the user to enter how many hours since their last drink.
        integer 'hoursSince'
        If input does not equal a number:
            Prompt the user to enter a number.
    Calculate the user's BAC using the formula: ('ounces' * 5.14 / 'weight' * 'sex') - 0.015 * 'hoursSince'
        Output the user's BAC.
        If BAC < 'BAC_LIMIT':
            Output "It is legal for you to drive."
        Else:
            Output "It is not legal for you to drive."
 */

import java.util.Scanner;

public class Solution17 {

    private static final double MALCOHOLDIST = 0.73;
    private static final double FALCOHOLDIST = 0.66;
    private static final double BACLIMIT = 0.08;

    private static final Scanner input = new Scanner(System.in);

    public double numericalLoop(String response) {
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

    public double genderNumberLoop(String response) {
        while (true) {
            try {
                if (Integer.parseInt(response) == 1)
                    return MALCOHOLDIST;
                else if (Integer.parseInt(response) == 2)
                    return FALCOHOLDIST;
                else {
                    System.out.printf("%s is not 1 or 2. Please enter a value: ", response);
                    response = input.nextLine();
                }
            }
            catch (NumberFormatException e) {
                System.out.printf("%s is not 1 or 2. Please enter a value: ", response);
                response = input.nextLine();
            }
        }
    }

    public double bacCalc(double gender, double ounces, double weight, double hoursSince) {
        return (ounces * 5.14 / weight * gender) - 0.015 * hoursSince;
    }

    public static void main(String[] arg) {
        double gender;
        double ounces;
        double weight;
        double hoursSince;
        double bac;

        Solution17 calculator = new Solution17();

        System.out.print("Enter a 1 if you are male or a 2 if you are female: ");
        String response = input.nextLine();
        gender = calculator.genderNumberLoop(response);

        System.out.print("How many ounces of alcohol did you have? ");
        response = input.nextLine();
        ounces = calculator.numericalLoop(response);

        System.out.print("What is your weight, in pounds? ");
        response = input.nextLine();
        weight = calculator.numericalLoop(response);

        System.out.print("How many hours has it been since your last drink? ");
        response = input.nextLine();
        hoursSince = calculator.numericalLoop(response);

        bac = calculator.bacCalc(gender, ounces, weight, hoursSince);

        System.out.printf("%nYour BAC is %.6f%n", bac);
        if (bac < BACLIMIT) {
            System.out.println("It is legal for you to drive.");
        }
        else {
            System.out.println("It is not legal for you to drive.");
        }

    }

}
