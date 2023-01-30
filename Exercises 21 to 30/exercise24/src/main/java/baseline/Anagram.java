/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Zander Preston
 */

package baseline;

import java.util.Arrays;

public class Anagram {

    public String sortString(String inputString) {
        //Creates a temporary array and sorts it, returning the array as a string.
        char[] tempArray = inputString.toCharArray();

        Arrays.sort(tempArray);

        return new String(tempArray);
    }

    public boolean isAnagram(String firstString, String secondString) {
        //Sorts the strings and returns true or false based on whether the sorted strings are equal to one another.
        String firstSorted = sortString(firstString);
        String secondSorted = sortString(secondString);

        return firstSorted.equals(secondSorted);
    }

}
