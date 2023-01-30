/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Zander Preston
 */

package baseline;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Solution34Test {

    Solution34 test = new Solution34();

    @Test
    void capitalizeInputTest() {

        String testCase = "zander preston";

        String expected = "Zander Preston";
        String actual = test.takeCapitalizedInput(testCase);

        assertEquals(expected, actual);
    }

    @Test
    void createListTest() {
        String[] expectedArray = {"John Smith", "Jackie Johnson", "Chris Jones",
                                  "Amanda Cullen", "Jeremy Goodwin"};

        List<String> expected = new ArrayList<>();
        Collections.addAll(expected, expectedArray);

        List<String> actual;
        actual = test.createList();

        assertEquals(expected, actual);
    }

    @Test
    void deleteEmployeeTest() {
        String response = test.takeCapitalizedInput("chris jones");

        String[] expectedArray = {"John Smith", "Jackie Johnson",
                                  "Amanda Cullen", "Jeremy Goodwin"};

        List<String> expected = new ArrayList<>();
        Collections.addAll(expected, expectedArray);

        List<String> actual;
        actual = test.createList();

        actual = test.deleteEmployee(response, actual);

        assertEquals(expected, actual);
    }

}