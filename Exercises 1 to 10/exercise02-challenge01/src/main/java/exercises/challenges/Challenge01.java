/*
 *  UCF COP3330 Fall 2021 Assignment 1 Solution 2
 *  Copyright 2021 Zander Preston
 */

package exercises.challenges;

/*
 Write an application
    Prompt the user to enter a string
        Store user input in String variable 'userString'
        If the user enters nothing:
            Print that the user must enter something and loop back.
    Use 'string.length()' to count the number of characters in 'userString'.
        If 'string.length()' = 1:
            Print "'userString' has 'string.length()' character."
        Else:
            Print "'userString' has 'string.length()' characters."
 */

import java.util.Scanner;

public class Challenge01 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); //Scanner variable to store input
        System.out.println("What is your input string?");
        String userString = input.nextLine(); //Store input in 'userString'

        while (userString.equals("")) { //If the user inputs nothing
            System.out.println("You need to input an input string!"); //Prompt them to enter something
            userString = input.nextLine();
        }
        if (userString.length() == 1) //Print the correct statement based on how many characters.
            System.out.printf("%s has %d character.", userString, userString.length());
        else
            System.out.printf("%s has %d characters.", userString, userString.length());

    }
}
