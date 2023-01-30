/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Zander Preston
 */

package baseline;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NameSorterTest {

    NameSorter test = new NameSorter(new File("./data/test.txt"));

    @Test
    void createListOfNamesTest() {
        //Tests createListOfNames(), comparing result to a manually allocated list
        List<String> actual = test.createListOfNames();

        List<String> expected = new ArrayList<>();
        expected.add("Ling, Mai");
        expected.add("Johnson, Jim");
        expected.add("Zarnecki, Sabrina");
        expected.add("Jones, Chris");
        expected.add("Jones, Aaron");
        expected.add("Swift, Geoffrey");
        expected.add("Xiong, Fong");

        assertEquals(expected, actual);
    }

    @Test
    void sortNamesTest() {
        //Tests sortNames(), comparing output to a manually sorted list.
        List<String> names = test.createListOfNames();

        List<String> actual;
        actual = test.sortNames(names);

        List<String> expected = new ArrayList<>();
        expected.add("Johnson, Jim");
        expected.add("Jones, Aaron");
        expected.add("Jones, Chris");
        expected.add("Ling, Mai");
        expected.add("Swift, Geoffrey");
        expected.add("Xiong, Fong");
        expected.add("Zarnecki, Sabrina");

        assertEquals(expected, actual);
    }
}