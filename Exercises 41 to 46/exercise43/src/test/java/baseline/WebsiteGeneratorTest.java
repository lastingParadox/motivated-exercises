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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WebsiteGeneratorTest {

    WebsiteGenerator test = new WebsiteGenerator("test moment", "Zander Preston", "./data");

    @Test
    void createWebsiteTest() {
        //Tests the createWebsite() function, ensuring that the folder exists after creation.
        test.createWebsiteFolder();

        File actual = new File("./data/website/test_moment");

        assertTrue(actual.exists());
    }

    @Test
    void createFolderTest() {
        //Tests the createFolder() function, ensuring that the js folder exists after creation.
        test.createFolder("js");

        File actual = new File("./data/website/test_moment/js");

        assertTrue(actual.exists());
    }

    @Test
    void createHTMLTest() {
        //Tests the createHTML() function, ensuring that the index.html file exists after creation.
        StringBuilder actual = new StringBuilder();
        StringBuilder expected = new StringBuilder();

        test.createHTML();

        try (BufferedReader reader = new BufferedReader(new FileReader("./data/website/test_moment/index.html"))) {
            String line = reader.readLine();

            while (line != null) {
                actual.append(line);
                actual.append(String.format("%n"));
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        expected.append(String.format("<head>%n    <title>%s</title>%n", "test moment"));
        expected.append(String.format("    <meta name=\"author\" content=\"%s\">%n</head>", "Zander Preston"));
        expected.append(String.format("%n<body>%n    <a href=\"https://www.youtube.com/watch?v=iik25wqIuFo\">Click this</a>"));
        expected.append(String.format("%n</body>%n"));


        assertEquals(String.valueOf(expected), String.valueOf(actual));
    }

    @Test
    void returnOutputTest() {
        //Tests the returnOutput() function, ensuring that the correct statements are logged to the console.
        test.createFolder("js");

        String expected = String.format("Created ./website/%s", "test_moment") +
                          String.format("%nCreated ./website/%s/index.html", "test_moment") +
                          String.format("%nCreated ./website/%s/js/", "test_moment");

        String actual = test.returnOutput();

        assertEquals(expected, actual);
    }
}
