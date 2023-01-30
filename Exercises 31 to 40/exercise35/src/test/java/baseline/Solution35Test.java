/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Zander Preston
 */

package baseline;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Solution35Test {

    Solution35 test = new Solution35();

    @Test
    void getRandValueTest() {
        ArrayList<String> names = new ArrayList<>(Arrays.asList("Batman", "Joker", "Penguin", "Robin", "Mr. Freeze"));
        int actual = test.getRandValue(names);
        assertTrue(actual >= 0 && actual < 5);
    }

    @Test
    void chooseWinner() {
        ArrayList<String> names = new ArrayList<>(Arrays.asList("Batman", "Joker", "Penguin", "Robin", "Mr. Freeze"));
        int index = test.getRandValue(names);

        String actual = names.get(index);

        assertTrue(actual.equals("Batman") || actual.equals("Joker") || actual.equals("Penguin") ||
                            actual.equals("Robin") || actual.equals("Mr. Freeze"));
    }

}