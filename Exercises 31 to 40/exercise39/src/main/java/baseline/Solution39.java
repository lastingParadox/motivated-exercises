/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Zander Preston
 */

package baseline;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Exercise 39 - Sorting Records
//  Sorts a list of maps of employees and outputs the data in a tabular format.

public class Solution39 {

    private static final String FIRST = "first_name";
    private static final String LAST = "last_name";
    private static final String POSITION = "position";
    private static final String SEPARATION = "sd";

    public Map<String, String> createMap(String first, String last, String position, String separation) {
        //Reduces the clutter of creating and adding values to a map
        Map<String, String> map = new HashMap<>();

        map.put(FIRST, first);
        map.put(LAST, last);
        map.put(POSITION, position);
        map.put(SEPARATION, separation);

        return map;
    }

    public void sortList(List<Map<String, String>> employees) {
        //Uses List.sort to sort the maps one by one in the List.
            //Uses a lambda expression as a callback for comparing each map's last_name key.
        employees.sort(Comparator.comparing(map -> map.get(LAST)));
    }

    public void printTable(List<Map<String, String>> employees) {
        //Prints the table, formatted akin to the example response in the exercise.
        StringBuilder output = new StringBuilder();

        output.append(String.format("Name%17s Position%11s SeparationDate%n", "|", "|"));
        output.append(String.format("--------------------|-------------------|----------------%n"));

        for(Map<String, String> employee : employees) {
            output.append(String.format("%-20s| %-18s| %s%n", employee.get(FIRST)+" "+employee.get(LAST),
                                                            employee.get(POSITION), employee.get(SEPARATION)));
        }

        System.out.println(output);
    }

    public static void main(String[] arg) {
        //Creates a list of maps (Employees) and sorts them by last name
        //Prints out the employees, in order, in a formatted table
        Solution39 sorter = new Solution39();

        List<Map<String, String>> employeeList = new ArrayList<>();

        Map<String, String> temp = sorter.createMap("John", "Johnson", "Manager", "2016-12-31");
        employeeList.add(temp);

        temp = sorter.createMap("Tou", "Xiong", "Software Engineer", "2016-10-05");
        employeeList.add(temp);

        temp = sorter.createMap("Michaela", "Michaelson", "District Manager", "2015-12-19");
        employeeList.add(temp);

        temp = sorter.createMap("Jake", "Jacobson", "Programmer", "");
        employeeList.add(temp);

        temp = sorter.createMap("Jacquelyn", "Jackson", "DBA", "");
        employeeList.add(temp);

        temp = sorter.createMap("Sally", "Webber", "Web Developer", "2015-12-18");
        employeeList.add(temp);

        sorter.sortList(employeeList);

        sorter.printTable(employeeList);
    }
}
