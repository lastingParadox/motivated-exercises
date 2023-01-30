/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Zander Preston
 */

package baseline;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberGameTest {

    NumberGame test = new NumberGame();

    @Test
    void getRandomNumberTest() {
        int actual = test.getRandomNumber(2);
        assertTrue(actual > 0 && actual < 100);
    }

    @Test
    void validateIntTest() {
        int expected = 4;
        int actual = test.validateInt("4");

        assertEquals(expected, actual);
    }

    @Test
    void responseMatchesGameChoice() {
        int randomNum = test.getRandomNumber(2);
        int actual = test.validateInt(String.valueOf(randomNum));

        assertEquals(actual, randomNum);
    }
}