/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Zander Preston
 */

package baseline;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeartRateTest {

    HeartRate test = new HeartRate(22, 65);

    @Test
    void roundTest() {

        int expected = 145;
        int actual = test.round(144.8);

        assertEquals(expected, actual);
    }

    @Test
    void calcTargetHRTest() {

        double intensity = 0.6;

        double expected = 144.8;
        double actual = test.calcTargetHR(intensity);

        assertEquals(expected, actual);
    }

    @Test
    void createTargetTableTest() {
        String expected = (String.format("Resting Pulse: 65        Age: 22%n%n") +
                           String.format("Intensity    | Rate%n") +
                           String.format("-------------|--------%n") +
                           String.format("55%%          | 138 bpm%n") +
                           String.format("60%%          | 145 bpm%n") +
                           String.format("65%%          | 151 bpm%n") +
                           String.format("70%%          | 158 bpm%n") +
                           String.format("75%%          | 165 bpm%n") +
                           String.format("80%%          | 171 bpm%n") +
                           String.format("85%%          | 178 bpm%n") +
                           String.format("90%%          | 185 bpm%n") +
                           String.format("95%%          | 191 bpm%n"));

        String actual = test.createTargetTable();

        assertEquals(expected, actual);
    }

}