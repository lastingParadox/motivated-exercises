/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Zander Preston
 */

package baseline;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PaymentCalculator {

    private final double balance;
    private final double dailyRate;
    private final double monthPayment;

    public double round(double value, int decimalPlaces) {
        //Creates a temporary BigDecimal equal to value and rounds it up to the nearest decimalPlace.
        BigDecimal temp = BigDecimal.valueOf(value);
        temp = temp.setScale(decimalPlaces, RoundingMode.UP);
        return temp.doubleValue();
    }

    PaymentCalculator(double balance, double apr, double monthPayment) {
        //PaymentCalculator constructor that rounds up balance and monthPayment to the nearest cent
        // And gets the daily rate from the APR percentage.
        this.balance = round(balance, 2);
        dailyRate = (apr/100)/365;
        this.monthPayment = round(monthPayment, 2);
    }

    public int calculateMonthsUntilPaidOff() {
        //Calculates the number of months till the user pays off their debt.

        //monthstoPay is set equal to the formula for calculating months until the card is paid off.
        double monthstoPay = ((double)-1/30) * Math.log10(1 + (balance/monthPayment) * (1 - Math.pow((1 + dailyRate),30))) / Math.log10(1+dailyRate);

        //monthstoPay is rounded to the next month.
        monthstoPay = round(monthstoPay, 0);
        return (int)monthstoPay;
    }
}
