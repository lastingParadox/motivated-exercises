/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Zander Preston
 */

package baseline;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ResponseStats {

    private final int[] responseArray;

    ResponseStats(int[] responseArray) {
        //Constructor method; adds the array to the class.
        this.responseArray = responseArray;
    }

    public String printList() {
        //Prints the array of integers on a line.
        StringBuilder output = new StringBuilder();

        output.append("Numbers:");
        output.append(String.format(" %d", responseArray[0]));

        for (int i = 1; i < responseArray.length; i++) {
            output.append(String.format(", %d", responseArray[i]));
        }

        return String.valueOf(output);
    }

    public double average() {
        //Gets the average of the array of integers.
        int size = responseArray.length;
        double sum = 0;

        for (int value : responseArray) {
            sum += value;
        }

        //BigDecimal is used to internally round the average to the hundredths place.
        BigDecimal temp = BigDecimal.valueOf(sum/size);
        temp = temp.setScale(2, RoundingMode.HALF_UP);

        return temp.doubleValue();
    }

    public int min() {
        //Gets the minimum of the array of integers.
        int size = responseArray.length;
        int minimum = responseArray[0];

        for(int i = 1; i<size; i++) {
            if(responseArray[i] < minimum) {
                minimum = responseArray[i];
            }
        }
        return minimum;
    }

    public int max() {
        //Gets the maximum of the array of integers.
        int size = responseArray.length;
        int maximum = responseArray[0];

        for(int i = 1; i<size; i++) {
            if(responseArray[i] > maximum) {
                maximum = responseArray[i];
            }
        }
        return maximum;
    }

    public double std() {
        //Gets the standard deviation of the array of integers.
        int size = responseArray.length;
        double mean = average();
        double standardSum = 0;

        for(int value : responseArray) {
            standardSum += Math.pow((value - mean), 2);
        }

        //BigDecimal is used to internally round the standard deviation to the hundredths place.
        BigDecimal temp = BigDecimal.valueOf(Math.sqrt(standardSum/(size)));
        temp = temp.setScale(2, RoundingMode.HALF_UP);

        return temp.doubleValue();
    }
}
