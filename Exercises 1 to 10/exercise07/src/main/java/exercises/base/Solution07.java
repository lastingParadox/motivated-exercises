/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution 07
 *  Copyright 2021 Zander Preston
 */

package exercises.base;

/*
 Write an application
    Establish conversion factor from square meters to square feet as a constant double.
        'CONVERSION' = 0.09290304
    Prompt the user for the length and width of the room in feet.
        i.e., int variables 'length' and 'width' respectively.
        If the user does not provide a numerical value for the length and width:
            Output that it isn't a numerical value and store the new input.
        Output the dimensions of the room: "You entered dimensions of 'length' feet by 'width' feet."
    Calculate the area of the room, 'length' * 'width', stored in int 'areaFt'.
        Convert 'area' to square meters by multiplying it by 'CONVERSION', stored in double 'areaM'.
        Output the area in square feet and in square meters.
 */

import java.util.Scanner;

public class Solution07 {

    static final double CONVERSION = 0.09290304;

    private static final Scanner input = new Scanner(System.in);

    public double areaCalc(double length, double width) {
        return length * width;
    }

    public double areaConvert(double areaFt) {
        return areaFt * CONVERSION;
    }

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

    public static void main(String[] arg) {
        Solution07 calculator = new Solution07();

        System.out.print("What is the length of the room in feet? ");
        String response = input.nextLine();
        double length = calculator.numericalLoop(response);

        System.out.print("What is the width of the room in feet? ");
        response = input.nextLine();
        double width = calculator.numericalLoop(response);

        System.out.printf("You entered dimensions of %.2f feet by %.2f feet.%n", length, width);

        double areaFt = calculator.areaCalc(length, width);
        double areaM = calculator.areaConvert(areaFt);

        System.out.printf("The area is%n%.3f square feet%n%.3f square meters", areaFt, areaM);


    }
}
