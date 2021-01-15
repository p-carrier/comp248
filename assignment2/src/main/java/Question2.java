// -------------------------------------------------------
// Assignment 2
// Written by: Philippe Carrier  -  id 40153985
// For COMP 248 Section P – Fall 2019
// --------------------------------------------------------

import java.util.Scanner;

/**
 * Program that calculate the circumference of a square from the length of the side given by the user.
 * Then output a representation of the square with a side length equal to the one given by the user.
 *
 * @author Philippe Carrier
 * @since 10/11/2019
 */
public class Question2 {

    public static void main(String[] args) {

//        Scanner to capture the input of the user.
        Scanner scanner = new Scanner(System.in);

        System.out.println("---------------------------------------------------------");
        System.out.println("           Welcome to Circumference Calculator");
        System.out.println("---------------------------------------------------------\n");

        System.out.println("Please enter the length of the side!");
//        Length of the side of the square. (Value inputed by the user)
        int sideLength = scanner.nextInt();

        /*
           Calculate the circumference and output the value.
         */
        System.out.println("The  Circumference of the Square is " + (sideLength * 4));
        System.out.println();

        /*
           Calculate the representation of the square by looping through the square
           height and width to output the square with the diagonal when the width equals
           the height.
         */
        for(int squareHeight = 1; squareHeight <= sideLength; squareHeight++) {
            for (int squareWidth = 1; squareWidth <= sideLength; squareWidth++) {
                System.out.print(squareHeight == squareWidth ? "\\" : "X");
//                Add space to improve the visual aspect of the square
                if (squareWidth != sideLength) {
                    System.out.print(" ");
                }
            }
            System.out.print('\n');
        }

        System.out.println("\nThanks for using Circumference Calculator");
        scanner.close();
    }
}
