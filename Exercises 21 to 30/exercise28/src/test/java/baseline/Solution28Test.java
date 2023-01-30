/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Zander Preston
 */

package baseline;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution28Test {

    @Test
    void addTotal() {
        Solution28 numCalculator = new Solution28();

        int[] array = new int[]{1, 2, 3, 4, 5};

        int expected = 15;
        int actual = numCalculator.addTotal(array);

        assertEquals(expected, actual);
    }
}