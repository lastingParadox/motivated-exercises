/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Zander Preston
 */

package baseline;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Exercise 34 - Employee List Removal
//  Shows the user the list of employees and prompts the user for a name to remove.
//  Outputs the new list without the chosen employee.

public class Solution34 {

    private static final Scanner input = new Scanner(System.in);

    public String takeCapitalizedInput(String response) {
        //Takes the user's input and capitalizes it.
        //Appends characters to a StringBuilder and adds a capital letter for every space.
        StringBuilder capitalized = new StringBuilder();
        capitalized.append(Character.toUpperCase(response.charAt(0)));

        for(int i = 1; i < response.length(); i++) {
            char ch = response.charAt(i);

            if(response.charAt(i-1) == ' ') {
                capitalized.append(Character.toUpperCase(response.charAt(i)));
            }
            else {
                capitalized.append(ch);
            }
        }
        return String.valueOf(capitalized);
    }

    public List<String> createList() {
        //Creates the list of employees.
        List<String> employees = new ArrayList<>();

        employees.add("John Smith");
        employees.add("Jackie Johnson");
        employees.add("Chris Jones");
        employees.add("Amanda Cullen");
        employees.add("Jeremy Goodwin");

        return employees;
    }

    private void printList(List<String> employees) {
        //Prints the list of employees, along with the number of employees.
        System.out.printf("There are %d employees:%n", employees.size());

        for (Object employee : employees)
            System.out.println(employee);
    }

    public List<String> deleteEmployee(String response, List<String> employees) {
        //Deletes the employee based on the user's capitalized response.
        boolean deleted = false;
        for (int i = 0; i < employees.size(); i++) {
            if (response.equals(employees.get(i))) {
                employees.remove(employees.get(i));
                deleted = true;
            }
        }
        //If response isn't an employee name, gives an error message.
        if (!deleted)
            System.out.printf("Error: Invalid Employee Name: %s%n", response);
        return employees;
    }

    public static void main(String[] arg) {
        //Prints the list of employees and prompts for the user to type an employee's name.
        //The employee input is deleted from the list and the new list is printed.
        Solution34 lister = new Solution34();

        List<String> employees = lister.createList();
        lister.printList(employees);

        System.out.printf("%nEnter an employee name to remove: ");
        String response = input.nextLine();
        response = lister.takeCapitalizedInput(response);

        employees = lister.deleteEmployee(response, employees);

        System.out.println();
        lister.printList(employees);
    }
}
