/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution 19
 *  Copyright 2021 Zander Preston
 */

package exercises.base;

/*
 Write an application
    Prompt the user for their weight and height.
        Int variables 'weight' and 'height'
        While the user does not enter a whole number:
            Output "'input' is not a whole number. Please enter a value: "
            Store 'input' in the respective variable.
    Calculate the user's BMI.
        'bmi' = ('weight' / ('height' * 'height')) * 703
    Output the user's BMI.
    If the user's BMI is between 18.5 and 25:
        Output "You are within the ideal weight range."
    Else:
        Output "You are overweight. You should see your doctor."
 */

import java.util.Scanner;

public class Solution19 {

    private static final Scanner input = new Scanner(System.in);
    private static final double LOWRANGE = 19.5;
    private static final double HIGHRANGE = 25;

    public int numericalLoop(String response) {
        while (true) {
            try {
                return Integer.parseInt(response);
            }
            catch (NumberFormatException e) {
                System.out.printf("%s is not a whole number. Please enter a value: ", response);
                response = input.nextLine();
            }
        }
    }

    public double calcBMI(int weight, int height) {
        return ((double)weight / (height * height)) * 703;
    }

    public static void main(String[] arg) {

        Solution19 scale = new Solution19();

        System.out.print("Enter your weight, in whole pounds: ");
        int weight = scale.numericalLoop(input.nextLine());

        System.out.print("Enter your height, in inches: ");
        int height = scale.numericalLoop(input.nextLine());

        double bmi = scale.calcBMI(weight, height);

        System.out.printf("Your BMI is %.1f.%n", bmi);

        if (bmi >= LOWRANGE && bmi < HIGHRANGE)
            System.out.println("You are within the ideal weight range.");
        else if (bmi < LOWRANGE)
            System.out.println("You are underweight. You should see your doctor.");
        else
            System.out.println("You are overweight. You should see your doctor.");

    }
}
