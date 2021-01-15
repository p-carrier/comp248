// -------------------------------------------------------
// Assignment 2
// Written by: Philippe Carrier  -  id 40153985
// For COMP 248 Section P – Fall 2019
// --------------------------------------------------------

import java.util.Scanner;

/**
 * Program that ask for a month number from the user and return the name associated with that number as well as a
 * season greeting that represents the season associated with that month.
 *
 * @author Philippe Carrier
 * @since 10/11/2019
 */
public class Question1A {

    public static void main(String[] args) {

//        Scanner to capture the input of the user.
        Scanner scanner = new Scanner(System.in);
//        Value of the month input by the user.
        int monthValue;
//        Month name associated with the month value inputed by the user.
        String monthName = "";
//        Greeting associated with the season for the month chosen by the user.
        String seasonGreeting = "";

        System.out.println("---------------------------------------------------------");
        System.out.println("          Welcome to Month Calculator Program");
        System.out.println("---------------------------------------------------------\n");

        /*
          Ask for an input from the user that represent the month value.
         */
        System.out.print("Please enter the Month as a number 1-12: ");
        monthValue = scanner.nextInt();

        /*
          Evaluate the month value according to its respective season to get the season greetings. Then
          evaluate the month value to get the associated month name of the month chosen by the user.
         */
        if (monthValue < 4) {
            if (monthValue == 1) {
                monthName = "Farvardin";
            } else if (monthValue == 2) {
                monthName = "Ordibehesht";
            } else if (monthValue == 3) {
                monthName = "Khordad";
            }
            seasonGreeting = "Happy Spring";
        } else if (monthValue < 7) {
            if (monthValue == 4) {
                monthName = "Tir";
            } else if (monthValue == 5) {
                monthName = "Mordad";
            } else {
//                this monthValue will always be 6
                monthName = "Shahrivar";
            }
            seasonGreeting = "Have Fun in summer";
        } else if (monthValue < 10) {
            if (monthValue == 7) {
                monthName = "Mehr";
            } else if (monthValue == 8) {
                monthName = "Aban";
            } else {
//                this monthValue will always be 9
                monthName = "Azar";
            }
            seasonGreeting = "Ready For Fall";
        } else if (monthValue < 13) {
            if (monthValue == 10) {
                monthName = "Dey";
            } else if (monthValue == 11) {
                monthName = "Bahman";
            } else {
//                this monthValue will always be 12
                monthName = "Esfand";
            }
            seasonGreeting = "Keep warm Yourself in Winter";
        }
        /*
           Check if month name has a value to output an actual value.
           Then Output the message associated with the month.
         */
        if (monthName.equals("")) {
            System.out.println("This is not a valid month");
        } else {
            System.out.println("We are in " + monthName + ", " + seasonGreeting);
        }

        System.out.println("\nThanks for using Month Calculator Program");
        scanner.close();
    }
}
