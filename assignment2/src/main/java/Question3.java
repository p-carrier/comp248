// -------------------------------------------------------
// Assignment 2
// Written by: Philippe Carrier  -  id 40153985
// For COMP 248 Section P – Fall 2019
// --------------------------------------------------------

import java.util.Scanner;

/**
 * Program that calculate the result from a formula given by the user. The program
 * will evaluate each of the formula based on their mathematical operator and return the
 * result of the operation.
 *
 * @author Philippe Carrier
 * @since 10/11/2019
 */
public class Question3 {

    public static void main(String[] args) {

//        Scanner to get the input formula by the user.
        Scanner scanner = new Scanner(System.in);
//        First number in the equation.
        String num1;
//        Second number in the equation.
        String num2;
//        Mathematical operator indicating which operator to use.
        char operator = 0;
//        Mathematical expression being input by the user.
        String expression;

        System.out.println("---------------------------------------------------------");
        System.out.println("           Welcome to mini calculator program");
        System.out.println("---------------------------------------------------------\n");


        /*
           Infinite for loop that will run until the user input 'q' to exit the program.
         */
        for (;;) {
            System.out.println("Please enter the numbers along operation (press q to exit): \n");
            expression = scanner.next();
            System.out.println();
            if (expression.equals("q")) {
                break;
            }

            // Reinitialize the value of num1 and num2 for the new equation.
            num1 = "";
            num2 = "";

            /**
             * Separate the numbers and the operator given by the user into their own variable in order to
             * calculate the result of the equation and select the correct mathematical formula.
             */
            for (int i = 0, count = 0; i < expression.length(); i++) {
                char letter = expression.charAt(i);
                if (letter < '0' || letter > '9') {
                    count++;
                }
                if (count == 0) {
                    num1 += letter;
                } else if (count == 1) {
                    operator = letter;
                    count++;
                } else if (count == 2) {
                    num2 += letter;
                }
            }

            /*
               Calculate the result of the equation by choosing the correct formula base on the
               mathematical operator (variable operator) input by the user.
             */
            System.out.print("The answer is: ");
            if (operator == '+') {
                System.out.println(Double.parseDouble(num1) + Double.parseDouble(num2));
            } else if (operator == '-') {
                System.out.println(Double.parseDouble(num1) - Double.parseDouble(num2));
            }
            else if (operator == 'x') {
                System.out.println(Double.parseDouble(num1) * Double.parseDouble(num2));
            }
            else if (operator == '/') {
                System.out.println(Double.parseDouble(num1) / Double.parseDouble(num2));
            }

        }

        scanner.close();

        System.out.println("Thanks for using mini calculator program.");
    }
}
