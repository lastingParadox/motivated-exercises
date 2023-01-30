/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Zander Preston
 */

package baseline;

import java.util.Scanner;

//Exercise 31 - Karvonen Heart Rate
// - Prompts the user for their age and resting heart rate and returns a table of target rates
// - According to heart intensities from 55% to 95%

public class Solution31 {

    private static final Scanner input = new Scanner(System.in);

    private String takeInput(String prompt) {
        //Prints out the prompt and return user's input.
        System.out.print(prompt);
        return input.nextLine();
    }

    public int validateIntInput(String prompt, String response) {
        //Validates the user's input is an integer, if not, prompts the user to enter a number.
        int intResponse;
        while(true) {
            try {
                intResponse = Integer.parseInt(response);
                return intResponse;
            }
            catch (NumberFormatException e) {
                System.out.printf("%s is not a valid response. Please input an integer.%n", response);
                response = takeInput(prompt);
            }
        }
    }

    public static void main(String[] arg) {
        //Prompts the user for their age and resting heart rate
        //  Outputs a table of target heart rates for intensities 55% to 95% in increments of 5%
        Solution31 prompter = new Solution31();

        int age = prompter.validateIntInput("What is your age? ",
                prompter.takeInput("What is your age? "));

        int restingHR = prompter.validateIntInput("What is your resting heart rate? ",
                prompter.takeInput("What is your resting heart rate? "));

        HeartRate calculator = new HeartRate(age, restingHR);

        System.out.print(calculator.createTargetTable());
    }
}
