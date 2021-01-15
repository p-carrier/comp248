// ---------------------------------------------------------
// Assignment 1
// Written by: Philippe Carrier  40153985
// For COMP248 Section  - Fall 2019 TODO: ADD the section
// ---------------------------------------------------------

import java.util.Scanner;

/**
 * An app that prompt a user to input an amount of seconds and return it's value separated
 * in hours, minutes and seconds.
 *
 * @author Philippe Carrier
 * @since 2019-09-27
 */

public class TimeConverterDRY {

//    The number of seconds in a minute
    private final static int SEC_IN_MIN = 60;
//    The number of minutes in an hour
    private final static int MIN_IN_HOUR = 60;
//    The number of hours in a day
    private final static int HOUR_IN_DAY = 24;
//    The number of seconds in a day
    private final static int SEC_IN_DAY = SEC_IN_MIN * MIN_IN_HOUR * HOUR_IN_DAY;

    /**
     * Convert the time in seconds given by the user to a readable 24 hours format.
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

//        TODO: Refactor it to spaghetti code
        /**
         * Convert the amount of seconds to the equivalent amount of hours, minutes and seconds.
         * (ex: 12345 seconds -> 3 hours 25 minutes 45 seconds)
         */
//        int array of the amount of seconds converted to hours minutes and seconds
//        int[seconds, minutes, hours]
        int[] convertedTime = new int[3];

//        The amount of seconds remaining
        convertedTime[0] = timeInput % SEC_IN_MIN;
//        The round down amount of minutes in the time input
        convertedTime[1] = (timeInput / SEC_IN_MIN);
//        The absolute amount of hours in timeInput
        convertedTime[2] = convertedTime[1] / MIN_IN_HOUR;
//        The absolute remaining amount of minutes after removing hours from timeInput
        convertedTime[1] %= MIN_IN_HOUR;

        System.out.println(String
                .format("The correspond hours, minutes, seconds is %d hrs, %d mins, %d secs.",
                        convertedTime[2],
                        convertedTime[1],
                        convertedTime[0]));

        if (timeInput <= SEC_IN_DAY) {
            System.out.println(String.format("The valid time is: %s:%s:%s.",
                    (convertedTime[2] == 0 ? "0" : "") + convertedTime[2],
                    (convertedTime[1] == 0 ? "0" : "") + convertedTime[1],
                    (convertedTime[0] == 0 ? "0" : "") + convertedTime[0]));
        } else {
            System.out.println("There is no valid time of your input.");

            /**
             *  Swapped the first digit of the inputTime for the last digit
             *  (ex: 12345 -> 52341)
             */
//            The
            String swappedTime = Integer.toString(timeInput);
            swappedTime = swappedTime.substring(swappedTime.length() - 1)
                    + swappedTime.substring(1, swappedTime.length() - 1)
                    + swappedTime.substring(0, 1);
            System.out.println("The swapped sequence of the input time is:" + swappedTime);

//            int[] convertedSwappedTime = timeConversion(Integer.parseInt(swappedTime));
            /**
             * Convert the amount of seconds to the equivalent amount of hours, minutes and seconds.
             * (ex: 12345 seconds -> 3 hours 25 minutes 45 seconds)
             */
//        int array of the amount of seconds converted to hours minutes and seconds
//        int[seconds, minutes, hours]
            int[] convertedSwappedTime = new int[3];
            int swappedTimeInt = Integer.parseInt(swappedTime);
//        The amount of seconds remaining
            convertedSwappedTime[0] = swappedTimeInt % SEC_IN_MIN;
//        The round down amount of minutes in the time input
            convertedSwappedTime[1] = (swappedTimeInt / SEC_IN_MIN);
//        The absolute amount of hours in timeInput
            convertedSwappedTime[2] = convertedSwappedTime[1] / MIN_IN_HOUR;
//        The absolute remaining amount of minutes after removing hours from timeInput
            convertedSwappedTime[1] %= MIN_IN_HOUR;

            System.out.println(String
                    .format("The correspond hours, minutes, seconds is %d hrs, %d mins, %d secs.",
                            convertedSwappedTime[2],
                            convertedSwappedTime[1],
                            convertedSwappedTime[0]));
        }
        System.out.println("Thank you for using the Time Converter Program!");
    }

    /**
     * Convert the amount of seconds to the equivalent amount of hours, minutes and seconds.
     * (ex: 12345 seconds -> 3 hours 25 minutes 45 seconds)
     *
     * @param sec       the amount of seconds to convert
     * @return int[seconds, minutes, hours]   int array of converted time
     */
//    private static int[] timeConversion(int sec) {
//        int[] times = new int[3];
//
//        int[] secAndMin = timeDestructuring(sec, SEC_IN_MIN);
//        times[0] = secAndMin[1];
//
//        int[] minAndHour = timeDestructuring(secAndMin[0], MIN_IN_HOUR);
//        times[1] = minAndHour[1];
//        times[2] = minAndHour[0];
//
//        return times;
//    }

    /**
     * Separate the time given into it's higher denominator and itself
     * (ex: 200 minutes -> 3 hours 20 minutes)
     *
     * @param time      the amount of time to modify into different values
     * @param divisor   the value by which divide
     * @return int[higherDenominator, itself] (ex: int[hours, minutes])
//     */
//    private static int[] timeDestructuring(int time, int divisor) {
//        int[] times = new int[2];
//
//        times[0] = time / divisor;
//        times[1] = time % divisor;
//
//        return times;
//    }

    /**
     * Add a 0 if the value equals 0.
     * (ex: 0 -> 00)
     *
     * @param time  the time to be evaluated
     * @return      a String of the time value
//     */
//    private static String formatTime(String time) {
////        return time.equals("0") ? 0 + time : time;
//        return time.length() == 1 ? 0 + time : time;
//    }
}
