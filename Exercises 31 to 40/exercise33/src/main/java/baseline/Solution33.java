/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Zander Preston
 */

package baseline;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

//Exercise 33 - Magic 8 Ball
//  Asks the user for a question and returns with an answer of "Yes", "No", or "Ask again later."

public class Solution33 {

    Random random = new Random();
    Scanner input = new Scanner(System.in);

    private void takeQuestion() {
        //Prompts the user to enter a question and does nothing with their response.
        System.out.printf("What's your question?%n> ");
        input.nextLine();
        System.out.printf("%n");
    }

    public List<String> create8BallAnswers() {
        //Creates a list containing the 8ball's answers.
        List<String> ballAnswers = new ArrayList<>();

        ballAnswers.add("Yes.");
        ballAnswers.add("No.");
        ballAnswers.add("Ask again later.");

        return ballAnswers;
    }

    public int getRandNumber(List<String> answers) {
        //Gets a random number from 0 to the size of the 8ball answer list - 1.
        int range = answers.size();
        return random.nextInt(range);
    }

    public static void main(String[] args) {
        //Creates a list of 8ball responses, asks the user to enter a question, and responds with a random answer.
        Solution33 prompter = new Solution33();

        List<String> answers = prompter.create8BallAnswers();

        prompter.takeQuestion();

        int index = prompter.getRandNumber(answers);
        System.out.printf("%s", answers.get(index));
    }
}
