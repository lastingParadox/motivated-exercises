/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution 16
 *  Copyright 2021 Zander Preston
 */

package exercises.base;

/*
 Write application
    Prompt the user for their age.
        Stored in integer 'age'
        If the user did not input an integer:
            Output that the user did not input a valid age. Store the next input, and repeat if applicable.
    If 'age' < 16:
        Output "You are not old enough to legally drive."
    Else
        Output "You are old enough to legally drive."
 */

import java.util.Scanner;

public class Solution16 {

    private static final Scanner input = new Scanner(System.in);
    private static final int DRIVINGAGE = 16;

    public void readAge(int age) {
        String output = age < DRIVINGAGE ? "You are not old enough to legally drive." :
                                           "You are old enough to legally drive.";

        System.out.println(output);
    }

    //Sorry ten-and-a-half-year-olds, whole numbers only.
    public int ageLoop() {
        String response = input.nextLine();
        while (true) {
            try {
                return Integer.parseInt(response);
            }
            catch (NumberFormatException e) {
                System.out.printf("%s is not a valid age. Please enter a whole number: ", response);
                response = input.nextLine();
            }
        }
    }

    public static void main(String[] arg) {

        Solution16 judge = new Solution16();

        System.out.print("What is your age? ");
        int age = judge.ageLoop();

        judge.readAge(age);
    }
}
