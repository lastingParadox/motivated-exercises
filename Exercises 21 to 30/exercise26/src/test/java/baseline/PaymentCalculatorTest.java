/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Zander Preston
 */

package baseline;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentCalculatorTest {

    @Test
    void roundTest() {
        PaymentCalculator calculator = new PaymentCalculator(5000, 12, 100);

        double expected = 1000.46;
        double actual = calculator.round(1000.456, 2);

        assertEquals(expected, actual);
    }

    @Test
    void calculateMonthsUntilPaidOffTest() {
        PaymentCalculator calculator = new PaymentCalculator(5000, 12, 100);

        int expected = 70;
        int actual = calculator.calculateMonthsUntilPaidOff();

        assertEquals(expected, actual);
    }


}