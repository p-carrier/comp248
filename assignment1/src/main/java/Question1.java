// ---------------------------------------------------------
// Assignment 1
// Written by: Philippe Carrier,  40153985
// For COMP248 Section P - Fall 2019
// ---------------------------------------------------------


/**
 *  App that print out an example of a while loop in a single System.out.println().
 *
 * @author Philippe Carrier
 * @since 2019-09-27
 */

public class Question1 {

    /**
     * Print out a string
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("**************************************************");
        System.out.println("Welcome to the Print Out App");
        System.out.println("**************************************************\n");

        /**
         * String of an example of a while loop being printed out.
         */
        System.out.println("Welcome to COMP248 Java Programming!\n" +
                "Let's use programming to have some coffee when you work!\n" +
                "while(Working)\n" +
                "{\n" +
                "\tCoffeeMug.Drink();\n" +
                "\tworkTask.Execute();\n" +
                "\tif (coffeeMug == \"Empty\")\n" +
                "\t{\n" +
                "\t\tif (coffeePot == \"Empty\")\n" +
                "\t\t\tcoffeePot.Make();\n" +
                "\t\tcoffeeMug.Refill();\n" +
                "\t}\n" +
                "\tEnjoy your coffee!\n" +
                "}");

        System.out.println("\n**************************************************");
        System.out.println("Thanks you for using the Print Out App");
        System.out.println("**************************************************");
    }

}
