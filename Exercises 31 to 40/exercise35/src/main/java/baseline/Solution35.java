/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Zander Preston
 */

package baseline;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

//Exercise 35 - Picking a Winner
//  Prompts the user to input a list of names. Whenever the user is finished, returns a random name as the "winner".

public class Solution35 {

    Random random = new Random();
    Scanner input = new Scanner(System.in);

    private String takeInput() {
        //Returns the user's input.
        return input.nextLine();
    }

    public int getRandValue(List<String> names) {
        //Returns a random value between 0 and the size of the list of names.
        int index = names.size();
        return random.nextInt(index);
    }

    public List<String> makeList() {
        //Creates a list and asks the user for a name. If the name is blank, the list is returned.
        List<String> names = new ArrayList<>();

        System.out.print("Enter a name: ");
        String response = takeInput();

        while(!response.isBlank()) {
            names.add(response);
            System.out.print("Enter a name: ");
            response = takeInput();
        }
        return names;
    }

    public static void main(String[] arg) {
        //Prompts the user for names and prints out a random name to be the winner.
        Solution35 lister = new Solution35();

        System.out.println("Type in names and the program will pick a winner. Press enter whenever you are finished.");

        List<String> names = lister.makeList();

        //Validates that the list is not empty.
        while(names.isEmpty()) {
            System.out.println("You need to input at least one name!");
            names = lister.makeList();
        }

        int index = lister.getRandValue(names);

        System.out.printf("The winner is... %s.%n", names.get(index));

    }
}
