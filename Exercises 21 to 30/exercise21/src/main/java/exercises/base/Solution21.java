/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution 21
 *  Copyright 2021 Zander Preston
 */

package exercises.base;

/*
 Write an application
    Prompt the user for the number of the month
        Integer 'userMonth'
        If the user does not enter a whole number:
            Output that the user did not enter a month number and store the next input. Repeat if applicable.
    If 'userMonth' >= 1 or 'userMonth' <= 12:
        Store month (January, February, March, April...) corresponding to number in String 'monthOutput'
        Output "The name of the month is 'monthOutput'."
    Else:
        Output "Number 'userMonth' is outside of number range (1-12)."
 */

import java.util.Scanner;

public class Solution21 {

    private static final Scanner input = new Scanner(System.in);

    public void printMonth(int userMonth) {

        String monthOutput = switch (userMonth) {
            case 1 -> "January";
            case 2 -> "February";
            case 3 -> "March";
            case 4 -> "April";
            case 5 -> "May";
            case 6 -> "June";
            case 7 -> "July";
            case 8 -> "August";
            case 9 -> "September";
            case 10 -> "October";
            case 11 -> "November";
            case 12 -> "December";
            default -> {
                System.out.printf("Number %d is outside of number range (1-12).", userMonth);
                yield "null";
            }
        };

        if(userMonth >= 1 && userMonth <= 12)
            System.out.printf("The name of the month is %s.", monthOutput);

    }

    public int monthLoop() {
        String response = input.nextLine();
        while (true) {
            try {
                return Integer.parseInt(response);
            }
            catch (NumberFormatException e) {
                System.out.printf("%s is not a valid number. Please enter a value: ", response);
                response = input.nextLine();
            }
        }
    }

    public static void main(String[] arg) {

        Solution21 calendar = new Solution21();

        System.out.print("Please enter the number of the month: ");
        int userMonth = calendar.monthLoop();

        calendar.printMonth(userMonth);
    }
}
