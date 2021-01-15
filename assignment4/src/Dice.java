// -------------------------------------------------------
// Assignment 4
// Written by: Philippe Carrier  -  id 40153985
// For COMP 248 Section P – Fall 2019
// --------------------------------------------------------

import java.util.Random;

/**
 * Class that build a Dice instance
 *
 * @author Philippe Carrier
 * @since 12/01/2019
 */

public class Dice {

//    the first die value
    private int die1;
//    the second die value
    private int die2;

    public Dice() {
        die1 = die2 = 1;
    }

    /**
     * Getter for the die1 variable
     *
     * @return  {@link #die1}
     */
    public int getDie1() {
        return die1;
    }

    /**
     * Getter for the die2 variable
     *
     * @return  {@link #die2}
     */
    public int getDie2() {
        return die2;
    }

    /**
     * Generate a value for the two dice between 1 and 6 and add them together to get the
     * number of move the player will be able to do during his turn.
     *
     * @return the sum of {@link #die1} and {@link #die2}
     */
    public int rollDice() {
        Random random = new Random();
        die1 = random.nextInt(6) + 1;
        die2 = random.nextInt(6) + 1;
        return die1 + die2;
    }

    /**
     * Check if the player roll a double (the two dices variables are of equal values)
     *
     * @return true if {@link #die1} and {@link #die2} are equal, false if not
     */
    public boolean isDouble() {
        return die1 == die2;
    }

    /**
     * The String representation of the dice values
     *
     * @return The String representation of the dice values
     */
    public String toString() {
        return "Die 1: " + die1 +
                "\tDie 2: " + die2;
    }
}
