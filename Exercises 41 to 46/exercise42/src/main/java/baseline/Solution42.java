/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Zander Preston
 */

package baseline;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Solution42 {

    public String listOutput(List<Map<String, String>> employees) {
        //Returns the table containing the employees' last names, first names, and salaries.
        StringBuilder output = new StringBuilder();

        output.append(String.format("%-10s%-10s%s%n", "Last", "First", "Salary"));
        output.append("--------------------------");

        for (Map<String, String> employee : employees) {
            output.append(String.format("%n%-10s%-10s%s", employee.get("last_name"),
                                                        employee.get("first_name"), employee.get("salary")));
        }

        return String.valueOf(output);
    }

    public void writeOutput(File outputFile, String output) {
        //Writes the given output to the given output file
        try (FileWriter out = new FileWriter(outputFile)) {
            out.write(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] arg) {
        //Based on a list of employees in exercise42_input.txt, outputs the list of employees in a tabular format.
        EmployeeList lister = new EmployeeList();
        Solution42 printer = new Solution42();

        List<Map<String, String>> employees = lister.createEmployeeList(new File("./data/exercise42_input.txt"));

        String output = printer.listOutput(employees);

        printer.writeOutput(new File("./data/exercise42_output.txt"), output);

        System.out.println(output);

    }
}
