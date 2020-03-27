/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.text.DecimalFormat;

/**
 *
 * @author Steven Hogenson
 */
public class ArrayUtilities {

    private static double array[];

    public ArrayUtilities(double array[]) {
        this.array = array;

    }

    public static double calculateTotal(double array[]) {
        double accum = 0;
        for (int i = 0; i < array.length; i++) {
            accum += array[i];
        }

        return accum;
    }

    public static double calculateAverage(double array[]) {
        return calculateTotal(array) / array.length;
    }

    public static double calculateLargest(double array[]) {
        double largestVal = array[0];
        for (int i = 0; i < array.length; i++) {
            if (largestVal < array[i]) {
                largestVal = array[i];
            }
        }
        return largestVal;
    }

    public static double calculateSmallest(double array[]) {
        double smallestVal = array[0];
        for (int i = 0; i < array.length; i++) {
            if (smallestVal > array[i]) {
                smallestVal = array[i];
            }
        }
        return smallestVal;
    }

    public static double calculateRange(double array[]) {
        return (calculateLargest(array) - calculateSmallest(array));
    }

    public static void printOutput() {
        String outputString = "";
        String fmt = "%1$-10s";
        for (int i = 0; i < array.length; i++) {
            if (i % 5 == 0 && i != 0) {
                outputString += "\n";
            }
            outputString += String.format(fmt, array[i]);
        }

        outputString += "\n\nThere are " + array.length + " elements in the array.";
        outputString += "\nThe smallest value in the array is: " + calculateSmallest(array);
        outputString += "\nThe largest value in the array is: " + calculateLargest(array);
        outputString += "\nThe range of values in the array is: " + calculateRange(array);
        outputString += "\nThe sum of the values in the array is: " + new DecimalFormat("#.##").format(calculateTotal(array));
        outputString += "\nThe average of the values in the array is: " + new DecimalFormat("#.##").format(calculateAverage(array));

        System.out.println(outputString);
    }

}
