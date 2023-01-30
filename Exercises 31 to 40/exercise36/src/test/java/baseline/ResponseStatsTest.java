/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Zander Preston
 */

package baseline;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResponseStatsTest {

    ResponseStats test = new ResponseStats(new int[]{100, 200, 1000, 300});

    @Test
    void printListTest() {

        String expected = "Numbers: 100, 200, 1000, 300";
        String actual = test.printList();

        assertEquals(expected, actual);
    }

    @Test
    void averageTest() {

        double expected = 400.0;
        double actual = test.average();

        assertEquals(expected, actual);
    }

    @Test
    void minTest() {

        int expected = 100;
        int actual = test.min();

        assertEquals(expected, actual);
    }

    @Test
    void maxTest() {

        int expected = 1000;
        int actual = test.max();

        assertEquals(expected, actual);
    }

    @Test
    void stdTest() {

        double expected = 353.55;
        double actual = test.std();

        assertEquals(expected, actual);
    }
}