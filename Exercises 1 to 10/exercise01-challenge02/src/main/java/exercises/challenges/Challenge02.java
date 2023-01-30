/*
 *  UCF COP3330 Fall 2021 Assignment 1 Solution Challenge 2
 *  Copyright 2021 Zander Preston
 */


package exercises.challenges;

/*
 Write an application
    Prompt user to enter a name
        Store user input in String 'userName'
    Store 'userName' in map for special cases:
        Zander:
            "I'm sorry, Zander, I'm afraid I can't give you a proper greeting."
        Hollander:
            "Hello Dr. Hollander, I swear I'm reading the instructions."
        Knightro:
            "Knightro! Go Knights! Charge on!"
        Obama:
            "Hello President Obama, the 44th president of the United States."
        Jack or Sparrow:
            "No pirates allowed in my program, Jack Sparrow. Savvy?"
        Gibbs:
            "Slap me thrice and hand me to me mama. It's Gibbs!"
        Orb:
            "Orb? That's your name?"
        Omni-Man:
            "Omni-man, why did you make me do this? You're staying in my head so you can infiltrate my program!"
        Else:
            Concatenate greeting and 'userName' in separate String variable 'concatGreeting'
                i.e., "Hello, 'userName', nice to meet you!
    Print concatenated greeting.
 */

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Challenge02 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); //Creation of Scanner variable for input.
        System.out.println("What is your name?"); //Prompt the user for their name.

        String userName = input.nextLine(); //Store user input into 'userName'.

        Map<String, String> list = new HashMap<>(); //Create a map named list to store the special names and greetings

        list.put("Zander", "I'm sorry, Zander, I'm afraid I can't give you a proper greeting."); //2001: A Space Odyssey
        list.put("Hollander", "Dr. Hollander, I swear I'm reading the instructions."); //Follow instructions to succeed
        list.put("Knightro", "Knightro! Go Knights! Charge on!"); //Knights Chant
        list.put("Obama", "President Obama! How did you find my program?"); //Why would the president look at this
        list.put("Jack", "No pirates allowed in my program, Jack Sparrow. Savvy?"); //Pirates of the Caribbean
        list.put("Sparrow", "No pirates allowed in my program, Jack Sparrow. Savvy?");
        list.put("Gibbs", "Slap me thrice and hand me to me mama. It's Gibbs!"); //Pirates of the Caribbean
        list.put("Orb", "Orb? That's your name?"); //Orb is a weird word
        list.put("Omni-man", "Omni-man, why did you make me include you? " +
                "You're staying in my head so you can infiltrate my program!"); //Invincible

        String concatGreeting = ("Hello, " + userName + ", nice to meet you!"); //Generic greeting, concatenated with 'username'

        if (list.get(userName) != null) { //If 'userName' is one of the keys to 'list'
            System.out.println(list.get(userName)); //Print the associated value.
        }
        else {
            System.out.println(concatGreeting); //Print out the concatenated greeting and 'userName'.
        }

    }
}