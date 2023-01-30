/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Zander Preston
 */

package baseline;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class Solution45Test {

    Solution45 test = new Solution45();

    @Test
    void validateFileTest() {
        File expected = new File("./data/funny_moments.txt");

        File actual = test.validateFile("funny_moments", "./data");

        assertEquals(expected, actual);
    }

}