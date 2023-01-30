/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Zander Preston
 */

package baseline;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution30Test {
    @Test
    void multiplyTest() {
        Solution30 calculator = new Solution30();

        int expected = 144;
        int actual = calculator.multiply(12, 12);

        assertEquals(expected, actual);
    }

    @Test
    void createMultiplicationTableTest() {
        Solution30 calculator = new Solution30();

        String expected = "    1    2\n    2    4\n";
        String actual = calculator.createMultiplicationTable(2);

        assertEquals(expected, actual);
    }

}