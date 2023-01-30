/*
 *  UCF COP3330 Fall 2021 Assignment 1 Solution 2
 *  Copyright 2021 Zander Preston
 */

package exercises.base;

/*
 Write an application
    Prompt the user to enter a string
        Store user input in String variable 'userString'
    Use 'string.length()' to count the number of characters in 'userString'.
        If 'string.length()' = 1:
            Print "'userString' has 'string.length()' character."
        Else:
            Print "'userString' has 'string.length()' characters."
 */

import java.util.Scanner;

public class Solution02 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); //Scanner variable to store input

        System.out.println("What is your input string?");
        String userString = input.nextLine(); //Store input in 'userString'

        if (userString.length() == 1) //Print the correct statement based on how many characters.
            System.out.printf("%s has %d character.", userString, userString.length());
        else
            System.out.printf("%s has %d characters.", userString, userString.length());

    }
}
