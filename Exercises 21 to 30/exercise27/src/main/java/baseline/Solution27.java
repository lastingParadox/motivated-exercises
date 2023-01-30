/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Zander Preston
 */

package baseline;

import java.util.Scanner;

//Exercise 27 - Validating Inputs
//  - Prompts the user for employee information and validates that input based on a number of tests.
//  - Returns specific strings if any tests failed (or not)

public class Solution27 {

    private static final Scanner input = new Scanner(System.in);

    private String takeInput(String prompt) {
        //Prints the prompt and takes in the user's input, returning it.
        System.out.print(prompt);
        return input.nextLine();
    }

    public static void main(String[] arg) {
        //Prompts the user for the employee's information and returns the errors (or lack of) associated with the input.
        Solution27 reader = new Solution27();

        //Prompts the user for the first name, last name, ZIP code, and ID.
        String firstName = reader.takeInput("Enter the first name: ");
        String lastName = reader.takeInput("Enter the last name: ");
        String zipcode = reader.takeInput("Enter the ZIP code: ");
        String id = reader.takeInput("Enter the employee ID: ");

        EmployeeValidator validator = new EmployeeValidator(firstName, lastName, zipcode, id);

        //Validates the responses and prints whether they fit the criteria below:
            //The first name must be filled in.
            //The last name must be filled in.
            //The first and last names must be at least two characters long.
            //An employee ID is in the format AA-1234. So, two letters, a hyphen, and four numbers.
            //The ZIP code must be a number.

        System.out.println(validator.validateInput());

    }
}
