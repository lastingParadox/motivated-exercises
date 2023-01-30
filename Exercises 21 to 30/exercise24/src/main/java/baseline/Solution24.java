/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Zander Preston
 */

package baseline;

import java.util.Scanner;

//Exercise24: Anagram Checker
//  Sees if two of the user's inputs are anagrams and returns whether they are anagrams of each other.

public class Solution24 {

    static final Scanner input = new Scanner(System.in);

    private String takeInput(String position) {
        //Prompts for the user's first or second input (based on the parameter) and returns the input in lowercase.
        System.out.printf("Enter the %s string: ", position);
        return input.nextLine().toLowerCase();
    }

    public static void main(String[] args) {
        //Prompts the user for two strings and outputs whether the strings are anagrams.
        Solution24 reader = new Solution24();
        Anagram sorter = new Anagram();

        //Actual prompt for the strings.
        System.out.println("Enter two strings and I'll tell you if they are anagrams:");

        String firstString = reader.takeInput("first");
        String secondString = reader.takeInput("second");

        if(sorter.isAnagram(firstString, secondString))
                System.out.printf("\"%s\" and \"%s\" are anagrams.", firstString, secondString);
        else
            System.out.printf("\"%s\" and \"%s\" are not anagrams.", firstString, secondString);
    }

}
