/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution 18
 *  Copyright 2021 Zander Preston
 */

package exercises.base;

/*
 Write an application
    Prompt the user to enter C or F; C for Celsius, F for Fahrenheit.
        Set input to .upper() and compare it to C/F
            Stored in String "tempScale"
        If user doesn't type C or F:
            Output "'input' is not C or F. Please enter C or F: "
            Store input again.
    Prompt the user to enter the temperature.
        Stored in integer "temperature"
        If user doesn't type a number:
            Output "'input is not numerical. Please enter a value: ".
    Depending on F or C, calculate the temperature conversion.
        F to C: C = (F − 32) × 5 / 9
        C to F: F = (C × 9 / 5) + 32
    Output the temperature conversion.
 */

import java.util.Scanner;

public class Solution18 {

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

    public double calculateTemp(double temperature, String tempScale) {
        if (tempScale.equals("C"))
            return (temperature - 32) * 5/9;
        else
            return (temperature * 9/5) + 32;
    }

    public static void main(String[] arg) {

        Solution18 thermometer = new Solution18();

        System.out.printf("Enter C to convert from Fahrenheit to Celsius%nEnter F to convert from Celsius to Fahrenheit.%nYour choice: ");
        String tempScale = input.nextLine().toUpperCase();

        while (!tempScale.equals("C") && !tempScale.equals("F")) {
            System.out.printf("%s is not C or F. Please enter C or F: ", tempScale);
            tempScale = input.nextLine().toUpperCase();
        }

        System.out.print(tempScale.equals("C") ? "Please enter the temperature in Fahrenheit: " : "Please enter the temperature in Celsius: ");
        double temperature = thermometer.numericalLoop(input.nextLine());

        double tempConvert = thermometer.calculateTemp(temperature, tempScale);
        System.out.printf(tempScale.equals("C") ? "The temperature in Celsius is %.2f." : "The temperature in Fahrenheit is %.2f.", tempConvert);
    }
}
