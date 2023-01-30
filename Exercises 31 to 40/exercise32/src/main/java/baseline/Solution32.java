/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Zander Preston
 */

package baseline;

import java.util.Scanner;

//Exercise 32 - Guess the Number Game
//  Gets the user's chosen difficulty level (from 1-3) and generates a random number between 1 to 10^difficulty.
//  Once the user guesses the number, returns the number of guesses and asks if the user wants to play again.

public class Solution32 {

    private static final Scanner input = new Scanner(System.in);

    protected String takeInput() {
        //Takes the user's input.
        return input.nextLine();
    }

    public static void main(String[] arg) {
        //Asks the user to play Guess the Number.
        //After the user guesses the number, asks the user if they want to play again.

        Solution32 prompter = new Solution32();
        NumberGame game = new NumberGame();

        String playGame = "y";

        System.out.printf("Let's play Guess the Number!%n%n");

        //The Guess the Number game, repeating whenever the user inputs "y" or "Y" when prompted.
        while(playGame.equals("y")) {
            game.setDifficulty();
            game.playGame();

            System.out.print("Do you wish to play again (Y/N)? ");
            playGame = prompter.takeInput().toLowerCase();

            //Validates the user's response to playing again.
            while(!playGame.equals("n") && !playGame.equals("y")) {
                System.out.println("Invalid Response");
                System.out.print("Do you wish to play again (Y/N)? ");
                playGame = prompter.takeInput().toLowerCase();
            }
        }

    }

}
