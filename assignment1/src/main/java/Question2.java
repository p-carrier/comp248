// ---------------------------------------------------------
// Assignment 1
// Written by: Philippe Carrier,  40153985
// For COMP248 Section P - Fall 2019
// ---------------------------------------------------------

import java.util.Scanner;

/**
 * An app that prompt a user to input an amount of seconds and return it's value separated
 * in hours, minutes and seconds.
 *
 * @author Philippe Carrier
 * @since 2019-09-27
 */

public class Question2 {

//    The number of seconds in a minute
    private final static int SEC_IN_MIN = 60;
//    The number of minutes in an hour
    private final static int MIN_IN_HOUR = 60;
//    The number of hours in a day
    private final static int HOUR_IN_DAY = 24;
//    The number of seconds in a day
    private final static int SEC_IN_DAY = SEC_IN_MIN * MIN_IN_HOUR * HOUR_IN_DAY;

    /**
     * Convert the time in seconds given by the user to a readable hours, minutes,
     * seconds format.
     *
     * @param args
     */
    public static void main(String[] args) {
//        Scanner to capture the time input
        Scanner scanner = new Scanner(System.in);

        System.out.println("**************************************************");
        System.out.println("Welcome to Time Converter Program");
        System.out.println("**************************************************\n");
        System.out.print("Please enter the seconds which will be converted: ");

//        The time input by the user
        int timeInput = scanner.nextInt();
        scanner.close();

        /**
         * Convert the amount of seconds to the equivalent amount of hours, minutes and seconds.
         * (ex: 12345 seconds -> 3 hours 25 minutes 45 seconds)
         */
//        int[seconds, minutes, hours] array of the amount of seconds from timeInput converted 
//        to hours minutes and seconds    
        int[] convertedTime = new int[3];

//        The amount of seconds remaining after removing hours and minutes from timeInput
        convertedTime[0] = timeInput % SEC_IN_MIN;
//        The round down amount of minutes in the time input
        convertedTime[1] = (timeInput / SEC_IN_MIN);
//        The round down amount of hours in timeInput
        convertedTime[2] = convertedTime[1] / MIN_IN_HOUR;
//        The round down remaining amount of minutes after removing hours from timeInput
        convertedTime[1] %= MIN_IN_HOUR;

        System.out.println(String
                .format("The correspond hours, minutes, seconds is %d hrs, %d mins, %d secs.",
                        convertedTime[2],
                        convertedTime[1],
                        convertedTime[0]));

        if (timeInput <= SEC_IN_DAY) {
            System.out.println(String.format("The valid time is: %s:%s:%s.",
//                    Adding a 0 in front a the value in time if it's equal to 0
                    (convertedTime[2] == 0 ? "0" : "") + convertedTime[2],
                    (convertedTime[1] == 0 ? "0" : "") + convertedTime[1],
                    (convertedTime[0] == 0 ? "0" : "") + convertedTime[0]));
        } else {
            System.out.println("There is no valid time of your input.");

            /**
             *  Swapped the first digit of the inputTime for the last digit
             *  (ex: 12345 -> 52341)
             */
//            The inputTime with swapped first and last digit
            String swappedTime = Integer.toString(timeInput);
            swappedTime = swappedTime.substring(swappedTime.length() - 1)
                    + swappedTime.substring(1, swappedTime.length() - 1)
                    + swappedTime.substring(0, 1);
            System.out.println("The swapped sequence of the input time is:" + swappedTime);

            /**
             * Convert the amount of seconds to the equivalent amount of hours, minutes and seconds.
             * (ex: 12345 seconds -> 3 hours 25 minutes 45 seconds)
             */
//        	  int[seconds, minutes, hours] array of the amount of seconds from swappedTimeInt
//            converted to hours, minutes and seconds
            int[] convertedSwappedTime = new int[3];
//            swappedTime parse to an integer
            int swappedTimeInt = Integer.parseInt(swappedTime);
//        	  The amount of seconds remaining after removing hours and minutes from swappedTimeInt
            convertedSwappedTime[0] = swappedTimeInt % SEC_IN_MIN;
//            The round down amount of minutes in the swappedTimeInt
            convertedSwappedTime[1] = (swappedTimeInt / SEC_IN_MIN);
//            The round down amount of hours in swappedTimeInt
            convertedSwappedTime[2] = convertedSwappedTime[1] / MIN_IN_HOUR;
//            The round down remaining amount of minutes after removing hours from swappedTimeInt
            convertedSwappedTime[1] %= MIN_IN_HOUR;

            System.out.println(String
                    .format("The correspond hours, minutes, seconds is %d hrs, %d mins, %d secs.",
                            convertedSwappedTime[2],
                            convertedSwappedTime[1],
                            convertedSwappedTime[0]));
        }
        System.out.println("\nThank you for using the Time Converter Program!");
    }
}
