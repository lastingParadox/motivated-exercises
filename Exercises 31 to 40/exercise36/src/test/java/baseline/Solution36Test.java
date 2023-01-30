/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Zander Preston
 */

package baseline;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Solution36Test {

    Solution36 test = new Solution36();

    @Test
    void createArrayTest() {

        List<Integer> testList = new ArrayList<>(Arrays.asList(100, 200, 1000, 300));

        int[] expected = {100, 200, 1000, 300};
        int[] actual = test.createArray(testList);

        //Just testing that each index is the same, hence the multiple asserts.
        assertEquals(expected[0], actual[0]);
        assertEquals(expected[1], actual[1]);
        assertEquals(expected[2], actual[2]);
        assertEquals(expected[3], actual[3]);
    }

}