/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution 15
 *  Copyright 2021 Zander Preston
 */

package exercises.base;

/*
 Write an application.
    Constant String 'PASSWORD' = "abc$123".
    Prompt the user for the password.
        String 'userPass'.
        If 'userPass'.equalsOf('PASSWORD'):
            Output "Welcome!"
        Else
            Output "I don't know you."
*/

import java.util.Scanner;

public class Solution15 {

    private static final String PASSWORD = "abc$123";
    private static final Scanner input = new Scanner(System.in);

    public void passReader(String password) {
        if (password.equals(PASSWORD))
            System.out.println("Welcome!");
        else
            System.out.println("I don't know you.");
    }

    public static void main(String[] arg) {

        Solution15 reader = new Solution15();

        System.out.print("What is your username? ");
        input.nextLine();

        System.out.print("What is the password? ");
        String password = input.nextLine();

        reader.passReader(password);
    }
}
