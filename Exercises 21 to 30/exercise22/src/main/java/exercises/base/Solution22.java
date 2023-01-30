/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution 22
 *  Copyright 2021 Zander Preston
 */

package exercises.base;

/*
 Write an application
    Prompt the user for three numbers ("Enter the nth number")
        Array 'numbers[3]'
        While the user does not input a whole number:
            Output that the user did not input a whole number and store the next input.
    Integer 'highestNumber' is set to 0
    Loop for i times:
        if 'numbers[i]' > 'highestNumber':
            'highestNumber' = 'numbers[i]'
    Output "The highest number is 'highestNumber'.
 */

import java.util.Scanner;

public class Solution22 {
    private static final Scanner input = new Scanner(System.in);
    private static final int VALUES = 3;

    public int getHighest(int[] numbers) {
        int highestNumber = 0;
        for (int i = 0; i < VALUES; i++) {
            if (numbers[i] > highestNumber)
                highestNumber = numbers[i];
        }
        return highestNumber;
    }

    public int numberLoop() {
        String response = input.nextLine();
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

    public static void main(String[] arg) {

        Solution22 highest = new Solution22();

        String[] numberPlace = {"first", "second", "third"};
        int[] numbers = new int[VALUES];

        for (int i = 0; i < VALUES; i++) {
            System.out.printf("Enter the %s number: ", numberPlace[i]);
            numbers[i] = highest.numberLoop();
        }
        int highestNumber = highest.getHighest(numbers);

        System.out.printf("The largest number is %d", highestNumber);
    }
}
