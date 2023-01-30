/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Zander Preston
 */

package baseline;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution31Test {

    @Test
    void validateIntInput() {
        //Probably not the best idea to test this, but doing so just in case
        Solution31 test = new Solution31();

        int expected = 4;
        int actual = test.validateIntInput("This test will pass", "4");

        assertEquals(expected, actual);
    }

}