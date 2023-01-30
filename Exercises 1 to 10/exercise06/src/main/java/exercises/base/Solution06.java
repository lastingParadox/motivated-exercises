/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution 06
 *  Copyright 2021 Zander Preston
 */

package exercises.base;

/*
 Write an application
    Prompt the user for their age and the age they would like to retire
        Stored in variables cast from strings into integers; 'currentAge' and 'retireAge'
    Calculate how many years the user has until retirement in method 'calcRetire()'
        Output "You have 'retireAge - currentAge' years until you can retire."
        Using instance Date variable 'currentYear' and attribute 'getYear()', get the current year.
            Add 'calcRetire' to the current year, stored in 'retireYear', and subtract 'currentAge'
            Output "It's 'currentYear', so you can retire in 'retireYear'."
 */

import java.util.Calendar;
import java.util.Scanner;

public class Solution06 {

    Calendar date = Calendar.getInstance();

    public void calcRetire(int currentAge, int retireAge) {

        System.out.printf("You have %d years until you can retire.%n", (retireAge - currentAge));

        int currentYear = date.get(Calendar.YEAR);
        int retireYear = (currentYear + retireAge - currentAge);

        System.out.printf("It's %d, so you can retire in %d.", currentYear, retireYear);
    }

    public static void main(String[] arg) {

        Scanner input = new Scanner(System.in);

        System.out.print("What is your current age? ");
        int currentAge = Integer.parseInt(input.nextLine());
        System.out.print("At what age would you like to retire? ");
        int retireAge = Integer.parseInt(input.nextLine());

        Solution06 retire = new Solution06();

        retire.calcRetire(currentAge, retireAge);

    }
}
