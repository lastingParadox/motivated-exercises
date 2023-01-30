/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Zander Preston
 */

package baseline;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NameSorter {

    private final File inputFile;

    NameSorter(File inputFile) {
        //Constructor for NameSorter
        this.inputFile = inputFile;
    }

    public List<String> createListOfNames() {
        //Tries to read in the file provided and returns a list of names provided each name is on a separate line.
        List<String> nameList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line = reader.readLine();
            while (line != null) {
                nameList.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return nameList;
    }

    public List<String> sortNames(List<String> names) {
        //Sorts the names in alphabetical order.
        Collections.sort(names);
        return names;
    }

    public String listOutput(List<String> names) {
        //Creates the table to output for the list of sorted names.
        StringBuilder output = new StringBuilder();
        output.append(String.format("Total of %s names%n", names.size()));
        output.append("-----------------");
        for (String name : names) {
            output.append(String.format("%n%s", name));
        }
        return String.valueOf(output);
    }
}
