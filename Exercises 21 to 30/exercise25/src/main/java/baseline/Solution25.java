/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Zander Preston
 */

package baseline;

import java.util.Scanner;

//Exercise 25 - Password Strength Indicator
//  Puts the user's input against a variety of tests and responds with how strong the password is based on those tests.

public class Solution25 {

    static final Scanner input = new Scanner(System.in);

    private String takePassword() {
        //Prompts the user to enter a password and returns it as a string.
        System.out.print("Please enter your password: ");
        return input.nextLine();
    }

    public static void main(String[] args) {
        //Prompts the user to input a password and outputs the strength of the password.
            //Password strength is based on the password strength criteria in class Password.

        Solution25 reader = new Solution25();

        Password validator = new Password();

        //String validation, in the case someone wants to not input something.
        String password = reader.takePassword();
        while (password.equals("")) {
            System.out.println("No password entered!");
            password = reader.takePassword();
        }

        int numIndicator = validator.passwordValidator(password);

        //Reads the strength passed by passwordValidator and converts it to something readable.
        String stringIndicator = switch (numIndicator) {
            case 0: yield "password of unknown strength";
            case 1: yield "very weak password";
            case 2: yield "weak password";
            case 3: yield "strong password";
            case 4: yield "very strong password";
            default:
                throw new IllegalArgumentException("Unexpected value: " + numIndicator);
        };

        System.out.printf("The password '%s' is a %s.%n", password, stringIndicator);

    }
}
