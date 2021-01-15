// -------------------------------------------------------
// Assignment 4
// Written by: Philippe Carrier  -  id 40153985
// For COMP 248 Section P – Fall 2019
// --------------------------------------------------------

import java.util.Random;
import java.util.Scanner;

/**
 * Class that build a Player instance
 *
 * @author Philippe Carrier
 * @since 12/01/2019
 */

public class Player {

//    The name of the player
    private String name;
//    The position of the player on the board (the level, the row and the column)
//    and the energy of the player
    private int level, x, y, energy;

    public Player() {
        this.name = "";
        this.energy = 10;
        this.level = 0;
        this.x = 0;
        this.y = 0;
    }

    public Player(String name) {
        this.name = name;
        this.energy = 10;
        this.level = 0;
        this.x = 0;
        this.y = 0;
    }

    public Player(int level, int x, int y) {
        this.name = "";
        this.energy = 10;
        this.level = level;
        this.x = x;
        this.y = y;
    }

    public Player(Player player) {
        this.name = player.name;
        this.energy = player.energy;
        this.level = player.level;
        this.x = player.x;
        this.y = player.y;
    }

    /**
     * Getter for the name variable
     *
     * @return {@link #name}
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the name variable
     *
     * @param name  the name of the player
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the level variable
     *
     * @return {@link #level}
     */
    public int getLevel() {
        return level;
    }

    /**
     * Setter for the level variable
     *
     * @param level  the level in which the player is located
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Getter for the x variable
     *
     * @return {@link #x}
     */
    public int getX() {
        return x;
    }

    /**
     * Setter for the x variable
     *
     * @param x the row in which the player is located
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Getter for the y variable
     *
     * @return {@link #y}
     */
    public int getY() {
        return y;
    }

    /**
     * Setter for the y variable
     *
     * @param y the column in which the player is located
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Getter for the energy variable
     *
     * @return {@link #energy}
     */
    public int getEnergy() {
        return energy;
    }

    /**
     * Setter for the energy variable
     *
     * @param energy the energy level of the player
     */
    public void setEnergy(int energy) {
        this.energy = energy;
    }

    /**
     * Set the {@link #level}, {@link #x} and {@link #y} of the current player to those
     * of another player object.
     *
     * @param player  @Player another player object with the new position of the current player
     */
    public void moveTo(Player player) {
        level = player.level;
        x = player.x;
        y = player.y;
    }

    /**
     * Check whether the current player has won the game
     *
     * @param board @Board the game board
     * @return  true if the player is located on the last case, false otherwise
     */
    public boolean won(Board board) {
        int level = board.getLevel();
        int size = board.getSize();
        return this.level == level - 1
                && this.x == size - 1
                && this.y == size - 1;
    }

    /**
     * Check if the current player is at the same position as another player
     *
     * @param player    @Player another player object
     * @return  true if at the same position, false otherwise
     */
    public boolean equals(Player player) {
        return level == player.level &&
                x == player.x &&
                y == player.y;
    }

    /**
     * The String representation of the Player
     *
     * @return The String representation of the Player
     */
    public String toString() {
        return "\t" + name + " is on level " + level +
                " at location (" + x + "," + y + ")" +
                " and has " + energy + " units of energy.";
    }

    /**
     * Mini game that player go through when they are out of energy. Their energy level
     * increase if they roll a double.
     *
     * @param dice  @Dice the dice the player play with
     * @param scanner   @Scanner scanner to input values
     */
    private void energyManagement(Dice dice, Scanner scanner) {
        for (int i = 0; i < 3; i++) {
            System.out.print("\tAny key to roll the dice... ");
            scanner.next();
            dice.rollDice();
            if (dice.isDouble()) {
                System.out.println("\tCongratulation you rolled double " + dice.getDie1() +
                        ". Your energy went up by 2 units");
                energy += 2;
            } else {
                System.out.println("\tYou didn't rolled a double. You energy stay the same");
            }

        }
    }

    /**
     * Mini game that takes place when the player land on the square occupied by the other player
     * and the player decide to challenge the other player for its position. If the generated
     * number is smaller than 6, the player lose the challenge.
     *
     * @param otherPlayer   @Player the opponent of the current player
     */
    private void challenge(Player otherPlayer) {
        Random random = new Random();
        if (random.nextInt(11) < 6) {
            System.out.println("Sorry. You lost the challenge.");
            energy /= 2;
        } else {
            System.out.println("Bravo!! You won the challenge.");
            Player dummyPlayer = new Player(otherPlayer);

            otherPlayer.moveTo(this);
            int halfEnergy = otherPlayer.getEnergy() / 2;
            otherPlayer.setEnergy(halfEnergy);

            moveTo(dummyPlayer);
            energy += halfEnergy;
        }
    }

    /**
     * The event surrounding the roll of the dice.
     *
     * @param dice  @Dice the dice the player play with
     * @return  int the value of the player movement this turn
     */
    private int rollDice(Dice dice) {
        int move = dice.rollDice();
        System.out.println("\t" + name + " you rolled " + dice.toString());

        if (dice.isDouble()) {
            System.out.println("\tCongratulations you rolled a double " + dice.getDie2() + "." +
                    " Your energy went up by 2 units.");
            energy += 2;
        }
        return move;
    }

    /**
     * Calculate the new position of the player after having rolled the dices.
     *
     * @param dice  @Dice the dice with which the player plays
     * @param board @Board the board game
     * @param isReverse boolean if the player has to go backward
     * @return  @Player the new position of the current player as a dummy Player object
     */
    private Player playerMovement(Dice dice, Board board, boolean isReverse) {
        int move = rollDice(dice);
        int boardSize = board.getSize();
        Player dummyPlayer = new Player(getLevel(), getX(), getY());

        if (isReverse) {
            int diceDiff = move % boardSize;
            dummyPlayer.setY(y + (diceDiff > y ? boardSize : 0) - diceDiff);
            diceDiff = move / boardSize;
            dummyPlayer.setX(x + (diceDiff > x ? boardSize : 0) - diceDiff);
            dummyPlayer.setLevel(level - diceDiff / boardSize);
        } else {
            dummyPlayer.setX(x + ((y + move) / boardSize));
            dummyPlayer.setY((y + move) % boardSize);
            dummyPlayer.setLevel(level + (dummyPlayer.getX() / boardSize));
            dummyPlayer.setX(dummyPlayer.getX() % boardSize);
        }
        return dummyPlayer;
    }

    /**
     * All the action that the player will do during his turn.
     *
     * @param otherPlayer  @Player the player against whom the current player is playing
     * @param dice  @Dice the dices the player will use to play
     * @param board @Board the game board
     * @param scanner @Scanner scanner to input value
     */
    public void turn(Player otherPlayer, Dice dice, Board board, Scanner scanner) {
//        if the player has to go backward because he is located on the second to last square
        boolean isReverse = false;

        System.out.println("It is " + name + "'s turn");

        if (energy <= 0) {
            System.out.println("\tYou don't have enough energy to play.");
            energyManagement(dice, scanner);
        }
        if (energy <= 0) {
            System.out.println("\tYou are too weak to play.");
            return;
        }

        if (level == board.getLevel() - 1 && x == board.getSize() - 1 && y == board.getSize() - 2) {
            isReverse = true;
            System.out.println("\tYou can't reach the exit from this position." +
                    "You will have to make some steps backward.");
        }

        Player dummyPlayer = playerMovement(dice, board, isReverse);
        if (dummyPlayer.equals(otherPlayer)) {
            System.out.println("Player " + otherPlayer.getName() + " is at your new position.");
            System.out.println("What do you want to do?");
            System.out.println("\t0 - Challenge and risk loosing 50% of your energy units if you" +
                    " loose\n\t\tor move to new location and get 50% of other player energy units");
            System.out.println("\t1 - to move down one level or move to (0, 0) if at level 0 and" +
                    " lose 2 energy");

            if (decision(scanner, 0 ,1) == 1) {
                energy -= 2;
                if (level == 0) {
                    x = y = 0;
                } else {
                    moveTo(dummyPlayer);
                    level -= 1;
                }
            } else {
                challenge(otherPlayer);
            }
        } else if (dummyPlayer.getLevel() < board.getLevel()) {
            int energyAdj = board.getEnergyAdj(
                    dummyPlayer.getLevel(),
                    dummyPlayer.getX(),
                    dummyPlayer.getY());
            System.out.println("\tYour energy is adjusted by " + energyAdj
                    + " for landing at (" + dummyPlayer.getX() + "," + dummyPlayer.getY() + ")" +
                    " at level " + dummyPlayer.getLevel());
            moveTo(dummyPlayer);
            energy += energyAdj;
        } else {
            System.out.println("!!! Sorry you need to stay where you are - that throw takes" +
                    " you off the grid and you\nloose 2 units of energy.");
            energy -= 2;
        }
    }

    /**
     * The player decides between two choices (values)
     *
     * @param scanner   @Scanner scanner to input value
     * @param choice1   the value of the first valid choice
     * @param choice2   the value of the second valid choice
     * @return  the choice of the player
     */
    public static int decision(Scanner scanner, int choice1, int choice2) {
        int choice;
        do {
            choice = scanner.nextInt();
        } while (!isDecisionValid(choice, choice1, choice2));
        return choice;
    }

    /**
     * Check if the player choice is valid
     *
     * @param choice    int the decision of the player
     * @param choice1   the value of the first valid choice
     * @param choice2   the value of the second valid choice
     * @return  true if choice is valid, false otherwise
     */
    private static boolean isDecisionValid(int choice, int choice1, int choice2) {
        if (choice != choice1 && choice != choice2) {
            System.out.println("Sorry but " + choice + " is not a legal choice.");
            return false;
        }
        return true;
    }
}
