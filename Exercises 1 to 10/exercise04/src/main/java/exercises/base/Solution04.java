/*
 *  UCF COP3330 Fall 2021 Assignment 1 Solution 4
 *  Copyright 2021 Zander Preston
 */

package exercises.base;

/*
 Write an application
    Prompt the user for a noun, verb, adjective, and adverb consecutively.
        Store these values in String variables 'noun', 'verb', 'adjective', and 'adverb' respectively.
        If the user inputs nothing for any of these values:
            Prompt the user to input something
            Store the input in the respective variable.
    Use 'string.indexOf' to see if the first letter of 'adjective' begins with a vowel.
        i.e., 'vowels.indexOf('adjective.charAt[0]')'
        If 'adjective' begins with a vowel:
            Print "Man, I wish I had an 'adjective' 'noun' that could 'adverb' 'verb'. That'd be amazing."
        Else:
            Print "Man, I wish I had a 'adjective' 'noun' that could 'adverb' 'verb'. That'd be amazing."
 */

import java.util.Scanner;

public class Solution04 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); //Scanner variable for storing user input
        String noun, verb, adjective, adverb;
        String vowels = "aeiou"; //String used to determine if adjective begins with a vowel

        System.out.println("Enter a noun:");
        noun = input.nextLine(); //Stores user input in 'noun'
        while (noun.equals("")) { //If the user inputs nothing
            System.out.println("You need to enter a noun!"); //Prompt user to input something
            noun = input.nextLine();
        }
        //Blocks that start with prompting the user to enter are nearly identical in structure.

        System.out.println("Enter a verb:");
        verb = input.nextLine();
        while (verb.equals("")) {
            System.out.println("You need to enter a verb!");
            verb = input.nextLine();
        }

        System.out.println("Enter an adjective:");
        adjective = input.nextLine();
        while (adjective.equals("")) {
            System.out.println("You need to enter an adjective!");
            adjective = input.nextLine();
        }

        String adjReader = adjective.toLowerCase(); //Used in determining if 'adjective' begins with a vowel
        String article; //Variable to determine what article to refer the adjective with

        System.out.println("Enter an adverb:");
        adverb = input.nextLine();
        while (adverb.equals("")) {
            System.out.println("You need to enter an adverb!");
            adverb = input.nextLine();
        }

        if(vowels.indexOf(adjReader.charAt(0)) != -1) //If the first letter of 'adjective' is a vowel
            article = "an";
        else
            article = "a";

        System.out.printf("Man, I wish I had %s %s %s that could %s %s. That'd be amazing.", //Print the mad lib sentence.
                article, adjective, noun, adverb, verb);
    }
}
