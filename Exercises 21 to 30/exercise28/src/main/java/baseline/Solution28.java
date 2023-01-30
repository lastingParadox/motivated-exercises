/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Zander Preston
 */

package baseline;

import java.util.Scanner;

//Exercise 28 - Adding Numbers
//  Takes in 5 numbers form the user and adds them using repetition (loop).

public class Solution28 {

    private static final int LOOPNUM = 5;
    private static final Scanner input = new Scanner(System.in);

    private int takeIntInput() {
        //Takes in the user's input and validates if it is an integer. If not, tells the user to enter a number.
        //Then returns the response.
        String response;

        //Prompts the user and stores their response.
        System.out.print("Enter a number: ");
        response = input.nextLine();

        return validateNum(response);
    }

    private int validateNum(String response) {
        //Validates that the user's input is an integer. If not, prompts the user to input another number.
        int intResponse;

        while (true) {
            try {
                intResponse = Integer.parseInt(response);
                return intResponse;
            } catch (NumberFormatException e) {
                System.out.printf("%s is not a number.%nEnter a number: ", response);
                response = input.nextLine();
            }
        }
    }

    public int addTotal() {
        //Prompts the user to enter a number LOOPNUM times and gets the total of the user's inputs.
        int total = 0;

        for (int i = 0; i<LOOPNUM; i++)
            total += takeIntInput();

        return total;
    }

    public int addTotal(int[] array) {
        //Overloaded addTotal() method that takes in an array of integers instead of user input.
        //Used in unit testing.
        int total = 0;

        for (int i = 0; i<LOOPNUM; i++)
            total += array[i];

        return total;
    }

    public static void main(String[] arg) {
        //Sets an integer equal to the total of the user's responses and prints it out.
        Solution28 numCalculator = new Solution28();

        int total = numCalculator.addTotal();

        System.out.printf("The total is %d.", total);
    }
}
