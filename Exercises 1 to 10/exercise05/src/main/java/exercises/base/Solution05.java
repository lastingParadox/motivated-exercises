/*
 *  UCF COP3330 Fall 2021 Assignment 1 Solution 5
 *  Copyright 2021 Zander Preston
 */

package exercises.base;

/*
 Write an application
    Prompt the user to input the first number.
        Store first number in integer 'firstNumber' by casting the String to an integer.
        If the user inputs nothing:
            Prompt the user to input a number.
            Store input in 'firstNumber'.
    Prompt the user to input the second number.
        Store second number in integer 'secondNumber' by casting the String to an integer.
        If the user inputs nothing:
            See above, in regard to 'secondNumber'.
    Calculate addition, subtraction, multiplication, and division of 'firstNumber' and 'secondNumber'
        Use separate variables 'sum', 'difference', 'product', and 'quotient' to equal the respective values
    Print all the operations, using a new line for each operation.
 */

import java.util.Scanner;

public class Solution05 {
    public static void main(String[] arg) {

        Scanner input = new Scanner(System.in);

        System.out.print("What is the first number? ");
        int firstNumber = Integer.parseInt(input.nextLine());

        System.out.print("What is the second number? ");
        int secondNumber = Integer.parseInt(input.nextLine());

        int sum = firstNumber + secondNumber;
        int difference = firstNumber - secondNumber;
        int product = firstNumber * secondNumber;
        int quotient = firstNumber / secondNumber;

        System.out.printf("%d + %d = %d\n%d - %d = %d\n%d * %d = %d\n%d / %d = %d",
                          firstNumber, secondNumber, sum, firstNumber, secondNumber, difference, firstNumber,
                          secondNumber, product, firstNumber, secondNumber, quotient);
    }
}
