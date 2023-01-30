/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Zander Preston
 */

package baseline;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Solution41Test {

    Solution41 test = new Solution41();
    NameSorter sorter = new NameSorter(new File("./data/test.txt"));

    @Test
    void writeOutputTest() {
        //Makes sure that the output file is created correctly from Solution41
        List<String> listNames = sorter.createListOfNames();
        listNames = sorter.sortNames(listNames);

        String output = sorter.listOutput(listNames);

        File actual = new File("./data/test_output.txt");
        test.writeOutput(actual, output);

        assertTrue(actual.exists());
    }

}