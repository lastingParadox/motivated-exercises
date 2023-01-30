/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Zander Preston
 */

package baseline;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FrequencySorterTest {

    FrequencySorter test = new FrequencySorter(new File("./data/test.txt"));

    @Test
    void createFrequencyMapTest() {
        //Compares the createFrequencyMap() function with a manually created map.
        Map<String, Integer> expected = new HashMap<>();

        expected.put("badger", 7);
        expected.put("mushroom", 2);
        expected.put("snake", 1);

        Map<String, Integer> actual = test.createFrequencyMap();

        assertEquals(expected, actual);
    }

    @Test
    void sortedMapListTest() {
        //Compares a String produced from the list from sortedMapList() with a pre-sorted String.
        Map<String, Integer> freqMap = test.createFrequencyMap();
        List<Map.Entry<String, Integer>> actualList = test.sortedMapList(freqMap);

        String expected = String.format("%s: %d%n", "badger", 7) +
                          String.format("%s: %d%n", "mushroom", 2) +
                          String.format("%s: %d%n", "snake", 1);

        StringBuilder actual = new StringBuilder();
        for (Map.Entry<String, Integer> entry : actualList) {
            actual.append(String.format("%s: %d%n", entry.getKey(), entry.getValue()));
        }

        assertEquals(expected, String.valueOf(actual));
    }

    @Test
    void histogramTest() {
        //Compares the histogram created from histogram() with a manually created histogram.
        Map<String, Integer> freqMap = test.createFrequencyMap();
        List<Map.Entry<String, Integer>> actualList = test.sortedMapList(freqMap);

        String expected = String.format("%s: %s%n", "badger", "*******") +
                          String.format("%s: %s%n", "mushroom", "**") +
                          String.format("%s: %s%n", "snake", "*");

        String actual = test.histogram(actualList);

        assertEquals(expected, actual);
    }

}