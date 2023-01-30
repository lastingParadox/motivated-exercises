/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Zander Preston
 */

package baseline;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution38Test {

    Solution38 test = new Solution38();

    @Test
    void convertToArrayTest() {

        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] actual = test.convertToArray("1 2 3 4 5 6 7 8");

        assertArrayEquals(expected, actual);
    }

    @Test
    void filterEvenNumbersTest() {
        int[] expected = {2, 4, 6, 8};

        int[] original = {1, 2, 3, 4, 5, 6, 7, 8};

        int[] actual = test.filterEvenNumbers(original);

        assertArrayEquals(expected, actual);
    }

    @Test
    void printArrayTest() {
        String expected = "2 4 6 8";

        int[] filtered = {2, 4, 6, 8};

        String actual = test.printArray(filtered);

        assertEquals(expected, actual);
    }

}