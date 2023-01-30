/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Zander Preston
 */

package baseline;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Exercise 38 - Filtering Values
//  Takes in the user's list of integers and returns only the even values from that list.

public class Solution38 {

    private static final Scanner input = new Scanner(System.in);

    private int validateValue(String response, int index) {
        //Validates that the user's response is an integer.
        int indexValue;

        while (true) {
            try {
                indexValue = Integer.parseInt(response);
                return indexValue;
            }
            catch (IllegalArgumentException e) {
                System.out.printf("Invalid input %s for index %d. Please input a single integer. ", response, index);
                response = input.nextLine();
            }
        }
    }

    public int[] convertToArray(String response) {
        //Splits the user's response into an array of strings
        //Then converts that array of strings into an array of integers and returns the result
        String[] tempArray = response.split(" ", 0);
        List<Integer> tempList = new ArrayList<>();

        for (int i = 0; i < tempArray.length; i++)
            tempList.add(validateValue(tempArray[i], i+1));

        int[] numArray = new int[tempList.size()];

        for (int i = 0; i < tempList.size(); i++)
            numArray[i] = tempList.get(i);

        return numArray;
    }

    public int[] filterEvenNumbers(int[] original) {
        //Filters out the odd numbers from the array and returns the filtered array.
        List<Integer> tempList = new ArrayList<>();

        for (int value : original) {
            if (value % 2 == 0)
                tempList.add(value);
        }

        int[] filtered = new int[tempList.size()];

        for(int i = 0; i < tempList.size(); i++)
            filtered[i] = tempList.get(i);

        return filtered;
    }

    public String printArray(int[] array) {
        //Outputs the array as a string with format "value value value..."
        StringBuilder output = new StringBuilder();

        output.append(array[0]);

        for (int i = 1; i<array.length; i++)
            output.append(String.format(" %d", array[i]));

        return String.valueOf(output);
    }

    public static void main(String[] arg) {
        //Prompts the user to input a list of numbers and outputs the even numbers from their input.
        Solution38 filterer = new Solution38();

        System.out.print("Enter a list of numbers, separated by a single space each: ");

        String response = input.nextLine();

        while (response.isBlank()) {
            System.out.println("Please input at least one integer value.");
            System.out.print("Enter a list of numbers, separated by spaces: ");
            response = input.nextLine();
        }

        int[] responseArray = filterer.convertToArray(response);
        responseArray = filterer.filterEvenNumbers(responseArray);

        System.out.printf("The even numbers are %s.%n", filterer.printArray(responseArray));
    }
}
