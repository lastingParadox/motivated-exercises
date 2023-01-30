/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution 23
 *  Copyright 2021 Zander Preston
 */

package exercises.base;

/*
 Write an application
    For any of the following questions, if the user enters something other than "y" or "n":
        Prompt the user to input "y" or "n" and store their response.
    Ask the user if the car is silent when the key is turned.
        If yes:
            Ask the user if the battery terminals are corroded.
                If yes:
                    Output "Clean terminals and try starting again."
                Else:
                    Output "Replace cables and try again."
        Else:
            Ask the user if the car makes a slicking noise.
                If yes:
                    Output "Replace the battery."
                Else:
                    Ask the user if the engine starts and then dies.
                        If yes:
                            Ask the user if the care has fuel injection.
                                If yes:
                                    Output "Get it in for service."
                                Else:
                                    Output "Check to ensure the choke is opening and closing."
                        Else:
                            Output "This should not be possible."
 */

import java.util.Scanner;

public class Solution23 {

    private static final Scanner input = new Scanner(System.in);

    public String answerSecurity() {
        String answer = input.nextLine().toLowerCase();

        while (!answer.equals("y") && !answer.equals("n")) {
            System.out.printf("%s is not y or n. Please enter y or n: ", answer);
            answer = input.nextLine().toLowerCase();
        }

        return answer;
    }

    public void silentMatrix() {

        System.out.print("Are the battery terminals corroded? ");
        String response = answerSecurity();

        if(response.equals("y"))
            System.out.print("Clean terminals and try starting again.");

        else
            System.out.print("Replace cables and try again.");

    }

    public void noiseMatrix() {

        System.out.print("Does the car make a slicking noise? ");
        String response = answerSecurity();

        if(response.equals("y"))
            System.out.print("Replace the battery.");

        else {
            System.out.print("Does the car crank up but fail to start? ");
            response = answerSecurity();

            if(response.equals("y"))
                System.out.print("Check spark plug connection.");

            else {
                System.out.print("Does the engine start and then die? ");
                response = answerSecurity();

                if(response.equals("y")) {
                    System.out.print("Does the car have fuel injection? ");
                    response = answerSecurity();

                    if(response.equals("y"))
                        System.out.print("Get it in for service.");
                    else
                        System.out.print("Check to ensure the choke is opening and closing.");
                }
                else
                    System.out.print("This should not be possible.");
            }
        }
    }

    public static void main(String[] arg) {

        Solution23 carQuestions = new Solution23();

        System.out.print("Is the car silent when you turn the key? ");
        String response = carQuestions.answerSecurity();

        if (response.equals("y"))
            carQuestions.silentMatrix();
        else
            carQuestions.noiseMatrix();
    }
}
