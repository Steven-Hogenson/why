/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constructorpractice;

import java.text.DateFormatSymbols;
import java.text.DecimalFormat;

/**
 *
 * @author Steven Hogenson
 */
public class RainFall {

    private double[] rain = new double[12];

    public RainFall(double[] rain) {
        this.rain = rain;

    }

    public double annualRain() {
        double accum = 0;
        for (int i = 0; i < rain.length; i++) {
            accum += rain[i];
        }
        return accum;
    }

    public double averageRain() {
        return (annualRain() / 12);
    }

    public int mostRain() {
        double mostRainMonth = rain[0];
        int index = 0;
        for (int i = 0; i < rain.length; i++) {
            if (mostRainMonth < rain[i]) {
                mostRainMonth = rain[i];
                index = i;
            }
        }
        return index;
    }

    public int leastRain() {
        double leastRainMonth = rain[0];
        int index = 0;
        for (int i = 0; i < rain.length; i++) {
            if (leastRainMonth > rain[i]) {
                leastRainMonth = rain[i];
                index = i;
            }
        }
        return index;
    }

    @Override
    public String toString() {
        String outputString = "";
        String fmt = "%1$10s %2$12s%n";
        System.out.printf(fmt, "MONTH", "RAIN");
        for (int i = 0; i < rain.length; i++) {
            outputString += String.format(fmt, new DateFormatSymbols().getMonths()[i], rain[i]);
        }

        outputString += "\nThe total rainfall for this year is " + annualRain();
        outputString += "\nThe average rainfall for this year is " + new DecimalFormat("#.##").format(averageRain());
        outputString += "\nThe month with the highest amount of rain is " + new DateFormatSymbols().getMonths()[mostRain()] + " with " + rain[mostRain()] + " inches.";
        outputString += "\nThe month with the lowest amount of rain is " + new DateFormatSymbols().getMonths()[leastRain()] + " with " + rain[leastRain()] + " inches.";
        return outputString;
    }
}
