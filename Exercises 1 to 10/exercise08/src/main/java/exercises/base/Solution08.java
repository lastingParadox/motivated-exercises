/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution 08
 *  Copyright 2021 Zander Preston
 */

package exercises.base;

/*
 Write an application
    Prompt the user for how many people are at the party, how many pizzas, and how many slices per pizza
        int variables 'numPeople', 'numPizzas', 'numSlices' respectively
        If the user does not enter a numerical value for one of these variables:
            Output that the user did not enter a numerical value and store the new input. Repeat if necessary.
    Output the number of people with the number of pizzas, and the total number of slices.
        The total number of slices is stored in integer variable 'totalSlices'
            'totalSlices' = 'numSlices' * 'numPizzas'
        i.e., "'numPeople' people with 'numPizzas' pizzas ('totalSlices' slices)"
    Calculate how many slices will be left over after the slices are evenly divided, and how many slices each person will get
        'leftover' = 'totalSlices' % 'numPeople'
        'totalSlices' = 'totalSlices' - 'leftover'
        'equalSlices' = 'totalSlices' / 'numPeople'
        Output how many slices each person will get and the leftover slices
            "Each person gets 'equalSlices' pieces of pizza.
             There are 'leftover' leftover pieces."
 */

import java.util.Scanner;

public class Solution08 {

    private static final Scanner input = new Scanner(System.in);

    public int leftoverCalc(int total, int people) {
        return total % people;
    }

    public int equalCalc(int total, int leftover, int people) {
        total = total - leftover;
        return total / people;
    }

    public int numericalLoop(String response) {
        while (true) {
            try {
                return Integer.parseInt(response);
            }
            catch (NumberFormatException e) {
                System.out.printf("%s is not a number. Please enter a value: ", response);
                response = input.nextLine();
            }
        }
    }

    public static void main(String[] arg) {
        Solution08 pizzaCalc = new Solution08();

        System.out.print("How many people? ");
        String response = input.nextLine();
        int numPeople = pizzaCalc.numericalLoop(response);

        System.out.print("How many pizzas do you have? ");
        response = input.nextLine();
        int numPizzas = pizzaCalc.numericalLoop(response);

        System.out.print("How many slices per pizza? ");
        response = input.nextLine();
        int numSlices = pizzaCalc.numericalLoop(response);

        int totalSlices = numSlices * numPizzas;

        System.out.printf("%d people with %d pizzas (%d slices)%n", numPeople, numPizzas, totalSlices);

        int leftover = pizzaCalc.leftoverCalc(totalSlices, numPeople);
        int equalSlices = pizzaCalc.equalCalc(totalSlices, leftover, numPeople);

        System.out.printf("Each person gets %d pieces of pizza.%nThere are %d leftover pieces.",
                           equalSlices, leftover);

    }
}
