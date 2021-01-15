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
public class Question1B {

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
        System.out.println("           Welcome to Month Calculator Program");
        System.out.println("---------------------------------------------------------\n");


        /*
           Ask for an input from the user to get the month value to evaluate.
         */
        System.out.print("Please enter the Month as a number 1-12: ");
        monthValue = scanner.nextInt();

        /*
           Evaluate the month value to get the name of the month chosen by the user and its associated
           season greeting.
         */
        switch (monthValue) {
            case 1:
                monthName = "Farvardin";
                seasonGreeting = "Happy Spring";
                break;
            case 2:
                monthName = "Ordibehesht";
                seasonGreeting = "Happy Spring";
                break;
            case 3:
                monthName = "Khordad";
                seasonGreeting = "Happy Spring";
                break;
            case 4:
                monthName = "Tir";
                seasonGreeting = "Have Fun in summer";
                break;
            case 5:
                monthName = "Mordad";
                seasonGreeting = "Have Fun in summer";
                break;
            case 6:
                monthName = "Shahrivar";
                seasonGreeting = "Have Fun in summer";
                break;
            case 7:
                monthName = "Mehr";
                seasonGreeting = "Ready For Fall";
                break;
            case 8:
                monthName = "Aban";
                seasonGreeting = "Ready For Fall";
                break;
            case 9:
                monthName = "Azar";
                seasonGreeting = "Ready For Fall";
                break;
            case 10:
                monthName = "Dey";
                seasonGreeting = "Keep warm Yourself in Winter";
                break;
            case 11:
                monthName = "Bahman";
                seasonGreeting = "Keep warm Yourself in Winter";
                break;
            case 12:
                monthName = "Esfand";
                seasonGreeting = "Keep warm Yourself in Winter";
                break;
        }

        /**
         * Check if month name has a value to output an actual value.
         * Then Output the message associated with the month to show the user
         * the answer.
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
