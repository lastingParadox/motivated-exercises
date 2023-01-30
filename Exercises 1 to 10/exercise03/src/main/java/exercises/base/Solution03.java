/*
 *  UCF COP3330 Fall 2021 Assignment 1 Solution 3
 *  Copyright 2021 Zander Preston
 */

package exercises.base;

/*
 Write an application
    Prompt the user to enter a quote.
        Store user input in 'quote'.
            If the user doesn't input anything:
                Prompt the user to input something.
                Store user input in 'quote'.
    Prompt the user to enter the name of who said the quote.
        Store user input in 'name'.
            If the user doesn't input anything:
                Prompt the user to input something.
                Store user input in 'name'.
    Print "'name' says, "'quote'".
 */

import java.util.Scanner;

public class Solution03 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); //New Scanner variable for input.

        System.out.println("What is the quote?");
        String quote = input.nextLine(); //User's input is stored in 'quote'.

        while (quote.equals("")) { //If the user inputs nothing
            System.out.println("You need to input a quote!"); //Prompt them to input something
            quote = input.nextLine();
        }

        System.out.println("Who said the quote?");
        String name = input.nextLine(); //User's input is stored in 'name'

        while (name.equals("")) { //If the user inputs nothing
            System.out.println("You need to input a name!"); //Prompt them to input something
            name = input.nextLine();
        }

        System.out.println(name + " says, \"" + quote + "\"."); //Print out the person and their quote.

    }
}
