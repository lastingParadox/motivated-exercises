/*
 *  UCF COP3330 Fall 2021 Assignment 1 Solution 1
 *  Copyright 2021 Zander Preston
 */

package exercises.base;

/*
 Write an application
    Prompt user to enter a name
        Store user input in String 'userName'
    Concatenate greeting and 'userName' in separate String variable 'concatGreeting'
        i.e., "Hello, 'userName', nice to meet you!
 Print concatenated greeting.
 */

import java.util.Scanner;

public class Solution01 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); //Creation of Scanner variable for input.
        System.out.println("What is your name?"); //Prompt the user for their name.

        String userName = input.nextLine(); //Store user input into 'userName'.
        String concatGreeting = ("Hello, " + userName + ", nice to meet you!");

        System.out.println(concatGreeting); //Print out the concatenated greeting and 'userName'.
    }
}