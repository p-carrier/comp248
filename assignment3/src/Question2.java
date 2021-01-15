// -------------------------------------------------------
// Assignment 3
// Written by: Philippe Carrier  -  id 40153985
// For COMP 248 Section P – Fall 2019
// --------------------------------------------------------

import java.util.Locale;

/**
 * Program that test the CPU class by creating two CPU instances and comparing the two of them.
 * Then it test the getter and setter function of the CPU class. And finally, it finds the price
 * that the CPU will have in a specific time in the future.
 *
 * @author Philippe Carrier
 * @since 11/04/2019
 */
public class Question2 {

    public static void main(String[] args) {

//        First Instance of the CPU class
        CPU CPU1 = new CPU();
//        Second Instance of the CPU class
        CPU CPU2 = new CPU(10, "i9", 3.1, true, 449.00, "Q2'19");

        System.out.println("Welcome to the simple class example!");
        System.out.println();

//        Test of the toString() method of the CPU class
        System.out.println("CPU 1: " + CPU1.toString());
        System.out.println("CPU 2: " + CPU2.toString());
        System.out.println();
//        Test of the getter methods of the CPU class
        System.out.println("CPU 1 Series: " + CPU1.getSeries());
        System.out.printf(
                Locale.CANADA,
                "CPU 1 Suggested price: %.2f USD%n",
                CPU1.getPrice()
        );
//        Test of the setter method of the CPU class
        CPU1.setPrice(110);
        System.out.printf(
                Locale.CANADA,
                "CPU 1 Suggested price (after mutator call): %.2f USD%n",
                CPU1.getPrice()
        );
        System.out.println();
//        Test of the equals function of the CPU class
        System.out.println("Are CPU 1 and CPU 2 equal? "
                + (CPU1.equals(CPU2) ? "YES" : "NO"));
//        Test of the isHigherGeneration method of the CPU class
        System.out.println("Is CPU 1 of higher generation than CPU 2? "
                + (CPU1.isHigherGeneration(CPU2) ? "YES" : "NO"));
        System.out.println();
//        Test of the priceNow method of the CPU class to get the price of the CPU at a specific
//        moment in time
        System.out.printf(
                Locale.CANADA,
                "CPU 1 Price at Q3'19: %.2f USD%n",
                CPU1.priceNow("Q3'19")
        );
        System.out.printf(
                Locale.CANADA,
                "CPU 2 Price at Q3'19: %.2f USD%n",
                CPU2.priceNow("Q3'19")
        );

        System.out.println();

        System.out.println("Thank you for testing the simple class example");
    }
}