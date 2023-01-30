/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Zander Preston
 */

package baseline;

import java.util.Random;

public class NumberGame {
    private int guessCount = 0;
    private int difficulty;

    private final Solution32 inputter = new Solution32();
    private final Random random = new Random();

    public void setDifficulty() {
        //Sets the difficulty of the game, validating the response is numerical and between 1 and 3.
        System.out.print("Enter the difficulty level (1, 2, or 3): ");
        String response = inputter.takeInput();
        int chosenDifficulty = 0;

        //While the difficulty is an incorrect value, prompts the user to input again.
        while (true) {
            try {
                chosenDifficulty = Integer.parseInt(response);
                if(chosenDifficulty < 1 || chosenDifficulty > 3) {
                    throw new IllegalArgumentException();
                }
                break;
            }
            catch (IllegalArgumentException e) {
                System.out.printf("Invalid difficulty!%n");
                System.out.print("Enter the difficulty level (1, 2, or 3): ");
                response = inputter.takeInput();
            }
        }
        difficulty = chosenDifficulty;
    }

    public int validateInt(String response) {
        //Validates the user's response is an integer.
        //If not, adds to the guess counter and asks the user to guess again.
        int responseInt;

        while(true) {
            try {
                responseInt = Integer.parseInt(response);
                return responseInt;
            }
            catch (NumberFormatException e) {
                guessCount++;
                System.out.print("Invalid guess! Guess again: ");
                response = inputter.takeInput();
            }
        }
    }

    public int getRandomNumber(int difficulty) {
        //Created to condense the random number getting process.
        //Returns the chosenNum for the game based on the difficulty.
        return random.nextInt((int)(Math.pow(10, difficulty) + 1));
    }

    public void playGame() {
        //After the difficulty is found, generates a random number based on the difficulty.
        //Asks the user to guess the random number, and finishes whenever the user gets the number correct.
        int chosenNum = getRandomNumber(difficulty);
        int playerGuessNum;
        String response;

        //Starts the game
        System.out.print("I have my number. What's your guess? ");
        guessCount++;
        response = inputter.takeInput();
        playerGuessNum = validateInt(response);

        //After the initial guess, continues this process until the user guesses correctly.
        while(playerGuessNum != chosenNum) {
            guessCount++;
            if (playerGuessNum < chosenNum) {
                System.out.print("Too low! Guess again: ");
            }
            else {
                System.out.print("Too high! Guess again: ");
            }
            response = inputter.takeInput();
            playerGuessNum = validateInt(response);
        }
        System.out.printf("You got it in %d guesses!%n%n", guessCount);
        guessCount = 0;
    }

}
