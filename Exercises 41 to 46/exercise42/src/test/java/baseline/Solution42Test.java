/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Zander Preston
 */

package baseline;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class Solution42Test {

    EmployeeList lister = new EmployeeList();
    Solution42 test = new Solution42();

    @Test
    void listOutputTest() {
        //Makes sure that listOutput() produces the proper table of employees.
        List<Map<String, String>> employees = lister.createEmployeeList(new File("./data/test_input.txt"));

        StringBuilder expected = new StringBuilder();
        expected.append(String.format("Last      First     Salary%n"));
        expected.append(String.format("--------------------------%n"));
        expected.append(String.format("Ling      Mai       55900%n"));
        expected.append(String.format("Johnson   Jim       56500%n"));
        expected.append(String.format("Jones     Aaron     46000%n"));
        expected.append(String.format("Jones     Chris     34500%n"));
        expected.append(String.format("Swift     Geoffrey  14200%n"));
        expected.append(String.format("Xiong     Fong      65000%n"));
        expected.append(String.format("Zarnecki  Sabrina   51500"));

        String actual = test.listOutput(employees);

        assertEquals(String.valueOf(expected), actual);
    }

    @Test
    void writeOutputTest() {
        //Ensures that the file is created when using writeOutput()
        List<Map<String, String>> employees = lister.createEmployeeList(new File("./data/test_input.txt"));
        String output = test.listOutput(employees);

        File actual = new File("./data/test_output.txt");
        test.writeOutput(actual, output);

        assertTrue(actual.exists());
    }

}