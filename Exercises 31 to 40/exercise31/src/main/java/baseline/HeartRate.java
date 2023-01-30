/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Zander Preston
 */

package baseline;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class HeartRate {
    private final int age;
    private final int restingHR;

    HeartRate(int age, int restingHR) {
        //Constructor
        this.age = age;
        this.restingHR = restingHR;
    }

    public int round(double target) {
        //Rounds the value given to the next integer.
        BigDecimal temp = BigDecimal.valueOf(target);
        temp = temp.setScale(0, RoundingMode.HALF_UP);
        return temp.intValue();
    }

    public double calcTargetHR(double intensity) {
        //Returns the target heart rate for the intensity.
        return (((220 - age) - restingHR) * intensity) + restingHR;
    }

    private StringBuilder createTargetTableHeader() {
        //Creates the table header to be displayed in the output.
        StringBuilder temp = new StringBuilder();

        temp.append(String.format("Resting Pulse: %d", restingHR));
        temp.append(String.format("%11s: %d%n%n", "Age", age));
        temp.append(String.format("Intensity%5s Rate%n-------------|--------%n", "|"));

        return temp;
    }

    public String createTargetTable() {
        //After the header, creates the rest of the table.
        //  Includes intensities from 55% to 95%
        double intensity;
        int target;

        StringBuilder temp = createTargetTableHeader();

        for(int i = 55; i<=95; i+=5) {
            temp.append(String.format("%d%% %10s ", i, "|"));
            intensity = ((double)i/100);
            target = round(calcTargetHR(intensity));
            temp.append(String.format("%d bpm%n", target));
        }
        return String.valueOf(temp);
    }
}
