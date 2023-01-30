/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Zander Preston
 */

package baseline;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution29Test {
    @Test
    void validateDoubleResponseTest() {
        Solution29 tester = new Solution29();

        double expected = 14.00;
        double actual = tester.validateDoubleResponse("14.00");

        assertEquals(expected, actual);
    }

    @Test
    void calcDoubleTimeTest() {
        Solution29 tester = new Solution29();

        double testInput = 4;

        double expected = 18;
        double actual = tester.calcDoubleTime(testInput);

        assertEquals(expected, actual);
    }
}