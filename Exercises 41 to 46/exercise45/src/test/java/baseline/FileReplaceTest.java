/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Zander Preston
 */

package baseline;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FileReplaceTest {

    FileReplace test = new FileReplace(new File("./data/test.txt"));

    @Test
    void readFileTest() {
        //Tests that the file was read and stored correctly.
        String expected = String.format("One should never utilize the word \"utilize\" in writing. Use \"use\" instead.%n" +
                                        "For example, \"She uses an IDE to write her Java programs\" instead of \"She%n" +
                                        "utilizes an IDE to write her Java programs\".");
        String actual = test.toString();

        assertEquals(expected, actual);
    }

    @Test
    void replaceWordTest() {
        //Tests that the word is replaced correctly throughout test's "lines" list
        String expected = String.format("One should never use the word \"use\" in writing. Use \"use\" instead.%n" +
                "For example, \"She uses an IDE to write her Java programs\" instead of \"She%n" +
                "uses an IDE to write her Java programs\".");

        test.replaceWord("utilize", "use");

        String actual = test.toString();

        assertEquals(expected, actual);
    }

    @Test
    void getOutputPathTest() {
        //Tests that the parent directory of the path provided on construction is assigned correctly.
        String expected = ".\\data";
        String actual = test.getOutputPath();

        assertEquals(expected, actual);
    }

    @Test
    void writeFileTest() {
        //Tests that the file containing the unedited lines is produced.
        File actual = new File("./data/test_output.txt");
        test.writeFile(actual);

        assertTrue(actual.exists());
    }

    @Test
    void writeReplacedFileTest() {
        //Tests that the file containing the edited lines is produced correctly.
        test.replaceWord("utilize", "use");
        File testFile = new File("./data/test_output2.txt");
        test.writeFile(testFile);

        StringBuilder actual = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader("./data/test_output2.txt"))) {
            String line = reader.readLine();

            actual.append(line);
            line = reader.readLine();

            while(line != null) {
                actual.append(String.format("%n"));
                actual.append(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String expected = String.format("One should never use the word \"use\" in writing. Use \"use\" instead.%n" +
                "For example, \"She uses an IDE to write her Java programs\" instead of \"She%n" +
                "uses an IDE to write her Java programs\".");

        assertEquals(expected, String.valueOf(actual));
    }

}