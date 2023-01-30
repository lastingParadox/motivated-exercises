/*
 *  UCF COP3330 Fall 2021 Assignment 1 Solution Challenge 1
 *  Copyright 2021 Zander Preston
 */

package exercises.challenges;

/*
 Write an application
    Prompt user to enter a name.
        Using a function 'getName()', return the name.
    Using a function 'concat()', concatenate the name with the greeting.
        i.e., "Hello, 'name', nice to meet you!
    Print concatenated greeting.
 */

import java.util.Scanner;

public class Challenge01 {
    public static String getName() { //Statement 1: Getting the user's name
        return new Scanner(System.in).nextLine();
    }

    public static String concat() { //Statement 2: Concatenating the greeting
        return ("Hello, " + getName() + ", nice to meet you!");
    }

    public static void main(String[] args) {

        System.out.println("What is your name?"); //Prompt the user for their name
        System.out.println(concat()); //Statement 3: Outputting the greeting.
    }
}
