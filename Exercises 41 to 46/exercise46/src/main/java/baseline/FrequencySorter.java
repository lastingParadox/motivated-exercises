/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Zander Preston
 */

package baseline;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FrequencySorter {

    private final File inputFile;

    FrequencySorter(File inputFile) {
        this.inputFile = inputFile;
    }

    public Map<String, Integer> createFrequencyMap() {
        //Tries to read the file provided and creates a map of how many times each word is used in the file.
        Map<String, Integer> wordMap = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line = reader.readLine();
            //Reads each line and adds to the counter for each word in the line.
            while (line != null) {
                String[] temp = line.split(" ");

                for (String word : temp) {
                    if (wordMap.containsKey(word)) {
                        wordMap.put(word, 1 + wordMap.get(word));
                    }
                    else {
                        wordMap.put(word, 1);
                    }
                }

                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordMap;
    }

    public List<Map.Entry<String, Integer>> sortedMapList(Map<String, Integer> wordMap) {
        //Sorts the data in the map into a list in descending order of value.
        List<Map.Entry<String, Integer>> list = new LinkedList<>(wordMap.entrySet());
        list.sort(Map.Entry.comparingByValue());
        Collections.reverse(list);
        return list;
    }

    public String histogram(List<Map.Entry<String, Integer>> list) {
        //Creates a histogram of the data in the list provided and returns it as a string.
        StringBuilder output = new StringBuilder();
        for (Map.Entry<String, Integer> entry : list) {
            String star = "*".repeat(Math.max(0, entry.getValue()));
            output.append(String.format("%s: %s%n", entry.getKey(), star));
        }
        return String.valueOf(output);
    }
}
