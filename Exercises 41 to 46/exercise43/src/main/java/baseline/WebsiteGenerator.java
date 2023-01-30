/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Zander Preston
 */

package baseline;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WebsiteGenerator {
    private final String siteName;
    private final String author;
    private final String filePath;
    private boolean js = false;
    private boolean css = false;

    WebsiteGenerator(String siteName, String author, String filePath) {
        //Constructor method, adds the website/'siteName' directory to filePath.
        this.siteName = siteName;
        this.author = author;
        this.filePath = filePath + "/website/" + siteName.toLowerCase().replace(' ', '_');
    }

    public void createWebsiteFolder(){
        //Creates the "./website/'siteName'" folder from the original filePath given
        Path path = Paths.get(this.filePath);

        try {
            Files.createDirectories(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createFolder(String folderName) {
        //Creates a folder in 'filePath' with the name given
        if (folderName.equals("js"))
            js = true;
        else if (folderName.equals("css"))
            css = true;

        Path path = Paths.get(filePath + String.format("/%s", folderName));

        try {
            Files.createDirectories(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createHTML() {
        //Creates an "index.html" file in the filePath.
        try (FileWriter out = new FileWriter(filePath + "/index.html")) {

            String html = String.format("<head>%n    <title>%s</title>%n", siteName) +
                          String.format("    <meta name=\"author\" content=\"%s\">%n</head>", author) +
                          String.format("%n<body>%n    <a href=\"https://www.youtube.com/watch?v=iik25wqIuFo\">Click this</a>") +
                          String.format("%n</body>");

            out.write(html);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String returnOutput() {
        //Returns the output to be printed to the console.
        StringBuilder output = new StringBuilder();

        String name = siteName.toLowerCase().replace(' ', '_');

        output.append(String.format("Created ./website/%s", name));
        output.append(String.format("%nCreated ./website/%s/index.html", name));

        if (js)
            output.append(String.format("%nCreated ./website/%s/js/", name));

        if (css)
            output.append(String.format("%nCreated ./website/%s/css/", name));

        return String.valueOf(output);
    }


}
