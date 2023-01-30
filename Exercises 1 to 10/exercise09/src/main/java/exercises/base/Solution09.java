/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution 09
 *  Copyright 2021 Zander Preston
 */

package exercises.base;

/*
 Write an application
    Create constant for conversion rate from gallons of paint to square feet.
        1 gallon = 350 sq. feet; int 'CONVERSION'
    Prompt the user for the length and width of the ceiling of the room.
        Int variables 'length' and 'width'.
        If user does not input a numerical value for either of these:
            Output that the user did not input a numerical value and store the new input. Repeat if necessary.
    Calculate the area of the ceiling, int 'ceilingArea'
        Calculate number of gallons needed to cover the ceiling.
            double 'gallons' = '(double)ceilingArea' / 'CONVERSION'.
                Use method Math.ceil() to round up 'gallons' to the next whole number.
    Output "You will need to purchase 'gallons' gallons of paint to cover 'ceilingArea' square feet.".
 */

import java.util.Scanner;

public class Solution09 {

    private static final int CONVERSION = 350;
    private static final Scanner input = new Scanner(System.in);

    public double calculateArea(double length, double width) {
        return length * width;
    }

    public int calculateGallons(double area) {
        double gallons = area / CONVERSION;
        gallons = Math.ceil(gallons);
        return (int)gallons;
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

        Solution09 calculator = new Solution09();

        System.out.print("What is the length of the ceiling? ");
        double length = calculator.numericalLoop();

        System.out.print("What is the width of the ceiling? ");
        double width = calculator.numericalLoop();

        double area = calculator.calculateArea(length, width);
        int gallons = calculator.calculateGallons(area);

        System.out.printf("You will need to purchase %d gallons of paint to cover %.2f square feet.", gallons, area);

    }
}
