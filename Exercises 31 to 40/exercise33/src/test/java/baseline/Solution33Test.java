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

class Solution33Test {

    Solution33 test = new Solution33();

    @Test
    void create8BallAnswersTest() {
        String[] expectedArray = {"Yes.","No.","Ask again later."};

        List<String> expected = new ArrayList<>();
        Collections.addAll(expected, expectedArray);

        List actual;
        actual = test.create8BallAnswers();

        assertEquals(expected, actual);
    }

    @Test
    void getRandNumberTest() {
        List<String> expectedList = test.create8BallAnswers();

        int actual = test.getRandNumber(expectedList);

        assertTrue(actual >= 0 && actual < expectedList.size());
    }

}