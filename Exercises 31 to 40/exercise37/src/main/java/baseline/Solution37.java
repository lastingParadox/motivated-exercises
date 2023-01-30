/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Zander Preston
 */

package baseline;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//Exercise 37 - Password Generator
//  Based on the given minimum length, number of special characters, and numbers, generates a random password.

public class Solution37 {

    private static final Scanner input = new Scanner(System.in);

    private String takeInput(String prompt) {
        //Prompts the user and takes in the user's input.
        System.out.print(prompt);
        return input.nextLine();
    }

    private int validateNumber(String prompt, String response) {
        //Validates that the user's response was a number.
        int responseNum;
        while(true) {
            try {
                responseNum = Integer.parseInt(response);

                //Verifies responseNum is not negative.
                if (responseNum < 0) {
                    throw new IllegalArgumentException();
                }

                return responseNum;
            }
            catch (IllegalArgumentException e) {
                System.out.println("Invalid response! Please input a positive whole number.");
                System.out.print(prompt);
                response = input.nextLine();
            }
        }
    }

    public List<Character> createAlphabet() {
        //Creates a list containing both the Uppercase and lowercase alphabet.
        Character[] tempArray = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S',
                                 'T','U','V','W','X','Y','Z','a','b','c','d','e','f','g','h','i','j','k','l',
                                 'm','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        List<Character> alphabetList = new ArrayList<>();

        Collections.addAll(alphabetList, tempArray);

        return alphabetList;
    }

    public List<Character> createSpecialList() {
        //Creates a list containing special characters.
        //"!"#$%&'()*+-./:;<=>?@[\]^_`{|}~"
        Character[] tempArray = {'!','"','#','$','%','&','\'','(',')','*','+',',','-','.','/',':',';','<','=',
                                 '>','?','@','[','\\',']','^','_','`','{','|','}','~'};
        List<Character> specialList = new ArrayList<>();

        Collections.addAll(specialList, tempArray);

        return specialList;
    }

    public List<Integer> createNumberList() {
        //Creates a list containing numbers 0-9
        Integer[] tempArray = {0,1,2,3,4,5,6,7,8,9};
        List<Integer> numberList = new ArrayList<>();

        Collections.addAll(numberList,tempArray);

        return numberList;
    }

    public static void main(String[] arg) {
        //Prompts the user for the:
            //Minimum password length, the number of digits, and the number of special characters.
        //Then, using that criteria, generates a random password.

        Solution37 prompter = new Solution37();

        int minLength;
        int numSpecial;
        int numNumbers;

        String tempPrompt = "What's the minimum length? ";
        minLength = prompter.validateNumber(tempPrompt, prompter.takeInput(tempPrompt));

        tempPrompt = "How many special characters? ";
        numSpecial = prompter.validateNumber(tempPrompt, prompter.takeInput(tempPrompt));

        tempPrompt = "How many numbers? ";
        numNumbers = prompter.validateNumber(tempPrompt, prompter.takeInput(tempPrompt));

        List<Character> alphabet = prompter.createAlphabet();
        List<Character> special = prompter.createSpecialList();
        List<Integer> numbers = prompter.createNumberList();

        Password passwordCreator = new Password(alphabet, special, numbers);

        String password = passwordCreator.createPassword(minLength, numSpecial, numNumbers);

        System.out.printf("Your password is %s%n", password);
    }

}
