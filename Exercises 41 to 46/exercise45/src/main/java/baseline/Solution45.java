/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Zander Preston
 */

package baseline;

import java.io.File;
import java.util.Scanner;

public class Solution45 {

    private static final Scanner input = new Scanner(System.in);

    private String promptUser() {
        //Prompts the user for the name of the output file.
        System.out.print("What is the name of the output file without the extension? ");
        return input.nextLine();
    }

    public File validateFile(String fileName, String outputPath) {
        //As a new file is being created, verifies that the file to be written does not exist.
        //If the file to be written does exist, gets the user to enter another name.
        File output = new File(String.format("%s/%s.txt", outputPath, fileName));
        while (output.exists()) {
            System.out.println("Sorry that file already exists.");
            fileName = promptUser();
            output = new File(String.format("%s/%s.txt", outputPath, fileName));
        }
        return output;
    }

    public static void main(String[] arg) {
        //Prompts the user to input a filename and returns the new version of the input file.
        Solution45 prompter = new Solution45();
        FileReplace replacer = new FileReplace(new File("./data/exercise45_input.txt"));

        String outputName = prompter.promptUser();

        replacer.replaceWord("utilize", "use");
        replacer.replaceWord("Utilize", "Use");

        File outputFile = prompter.validateFile(outputName, replacer.getOutputPath());

        replacer.writeFile(outputFile);

        System.out.printf("%nNew Text:%n");
        System.out.println(replacer);

    }
}
