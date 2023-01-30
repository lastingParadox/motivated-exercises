/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Zander Preston
 */

package baseline;

import java.io.File;
import java.util.List;
import java.util.Map;

public class Solution46 {

    public static void main(String[] arg) {
        //Reads in the file provided in the FrequencySorter and returns a histogram of the frequency of each word.
        FrequencySorter sorter = new FrequencySorter(new File("./data/exercise46_input.txt"));
        Map<String, Integer> freqMap = sorter.createFrequencyMap();

        List<Map.Entry<String, Integer>> list = sorter.sortedMapList(freqMap);

        String histogram = sorter.histogram(list);

        System.out.print(histogram);
    }
}