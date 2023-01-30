/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Zander Preston
 */

package baseline;

import java.util.Scanner;

public class Solution43 {

    private static final Scanner input = new Scanner(System.in);

    private String validateResponse(String response) {
        //Validates that the user input either "y" or "n"
        while(true) {
            if(response.equalsIgnoreCase("y") || response.equalsIgnoreCase("n"))
                return response;
            else {
                System.out.print("Invalid response, please input y or n. ");
                response = input.nextLine();
            }
        }
    }

    public static void main(String[] arg) {
        //Prompts the user for a site name and author name.
        //Creates a website 'index.html' and optional 'js' and 'css' folders in the "./data/" directory.
        Solution43 prompter = new Solution43();

        System.out.print("Site name: ");
        String siteName = input.nextLine();

        System.out.print("Author: ");
        String author = input.nextLine();

        WebsiteGenerator generator = new WebsiteGenerator(siteName, author, "./data");

        //Creates the website/'siteName' directory
        generator.createWebsiteFolder();

        //JavaScript prompt + folder creation
        System.out.print("Do you want a folder for JavaScript? ");
        String response = prompter.validateResponse(input.nextLine());
        if (response.equalsIgnoreCase("y")) {
            generator.createFolder("js");
        }

        //CSS prompt + folder creation
        System.out.print("Do you want a folder for CSS? ");
        response = prompter.validateResponse(input.nextLine());
        if (response.equalsIgnoreCase("y")) {
            generator.createFolder("css");
        }

        generator.createHTML();

        String output = generator.returnOutput();

        System.out.println(output);
    }
}
