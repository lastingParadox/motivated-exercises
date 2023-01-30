/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Zander Preston
 */

package baseline;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnagramTest {

    @Test
    void sortStringTest() {
        Anagram sorter = new Anagram();

        String input = "solution24";
        String expected = "24ilnoostu";
        String actual = sorter.sortString(input);

        assertEquals(expected, actual);
    }

    @Test
    void isAnagramTest() {
        Anagram sorter = new Anagram();

        String firstString = "note";
        String secondString = "tone";

        boolean actual = sorter.isAnagram(firstString, secondString);

        assertTrue(actual);
    }

}