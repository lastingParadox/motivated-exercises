/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Zander Preston
 */

package baseline;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileReplace {

    private final List<String> lines;
    private String outputPath;

    FileReplace(File path) {
        //Constructor that reads from the file provided and assigns the lines from it to lines.
        //Also gets the parent directory of the path provided and assigns it to outputPath.
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            outputPath = path.getParent();
            String line = reader.readLine();

            while(line != null) {
                list.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        lines = list;
    }

    public void replaceWord(String originalWord, String newWord) {
        //Replaces the chosen word on each line of the list.
        for (int i = 0; i < lines.size(); i++) {
            lines.set(i, lines.get(i).replace(originalWord, newWord));
        }
    }

    public String getOutputPath() {
        //Returns the directory to be containing the output file.
        return outputPath;
    }

    public void writeFile(File file) {
        //Creates and writes the lines from the list of strings in the file specified.
        try (FileWriter out = new FileWriter(file)) {
            StringBuilder outputText = new StringBuilder();

            for (int i = 0; i < lines.size(); i++) {
                outputText.append(lines.get(i));

                if (i != lines.size() - 1)
                    outputText.append(String.format("%n"));
            }

            out.write(String.valueOf(outputText));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        //Overrides the .toString() function to return/print out a formatted list contained in lines
        StringBuilder outputText = new StringBuilder();

        for (int i = 0; i < lines.size(); i++) {
            outputText.append(lines.get(i));

            if (i != lines.size() - 1)
                outputText.append(String.format("%n"));
        }
        return String.valueOf(outputText);
    }

}
