/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Zander Preston
 */

package baseline;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Solution41 {

    public void writeOutput(File outputFile, String output) {
        //Writes the output given to the file given
        try (FileWriter out = new FileWriter(outputFile)) {
            out.write(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] arg) {
        //Reads in a list of names from the input file and outputs the sorted names in a tabular format to the output.
        Solution41 writer = new Solution41();
        NameSorter sorter = new NameSorter(new File("./data/exercise41_input.txt"));

        List<String> names = sorter.createListOfNames();
        names = sorter.sortNames(names);

        String output = sorter.listOutput(names);

        writer.writeOutput(new File("./data/exercise41_output.txt"), output);
        System.out.println(output);

    }
}
