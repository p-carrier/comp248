// -------------------------------------------------------
// Assignment 4
// Written by: Philippe Carrier  -  id 40153985
// For COMP 248 Section P – Fall 2019
// --------------------------------------------------------

import java.util.Scanner;

/**
 * Class that build a Board instance
 *
 * @author Philippe Carrier
 * @since 12/01/2019
 */

public class Board {

//    the minimum size of the level
    private static final int MIN_LEVEL = 3;
//    the maximum size of the level
    private static final int MAX_LEVEL = 10;
//    the minimum size of the width and height of a level
    private static final int MIN_SIZE = 3;
//    the maximum size of the width and height of a level
    private static final int MAX_SIZE = 10;

//    the game board
    private final int[][][] board;
//    the amount of level in the game
    private final int level;
//    the width and height of a level
    private final int size;

    public Board() {
        level = 3;
        size = 4;
        board = createBoard(level, size);
    }

    public Board(int level, int size) {
        this.level = level;
        this.size = size;
        board = createBoard(level, size);
    }

    /**
     * Create the board for the game.
     *
     * @param level the number of level for the board
     * @param size  the height and width of a level
     * @return  the board
     */
    private int[][][] createBoard(int level, int size) {
        int[][][] board = new int[level][size][size];

        for (int l = 0; l < level; l++) {
            for (int x = 0; x < size; x++) {
                for (int y = 0; y < size; y++) {
                    int levelXYSum = l + x + y;
                    if (levelXYSum == 0) {
                        board[l][x][y] = 0;
                    } else if (levelXYSum % 3 == 0) {
                        board[l][x][y] = -3;
                    } else if (levelXYSum % 5 == 0) {
                        board[l][x][y] = -2;
                    } else if (levelXYSum % 7 == 0) {
                        board[l][x][y] = 2;
                    } else {
                        board[l][x][y] = 0;
                    }
                }
            }
        }

        return board;
    }

    /**
     * Getter for the level variable
     *
     * @return  {@link #level}
     */
    public int getLevel() {
        return level;
    }

    /**
     * Getter for the size variable
     *
     * @return  {@link #size}
     */
    public int getSize() {
        return size;
    }

    /**
     * Get the energy variance associated with the board position of the player.
     *
     * @param level the level in which the player is located
     * @param x the row in which the player is located
     * @param y the column in which the player is located
     * @return  an int for the value of the energy adjustment on the board position
     */
    public int getEnergyAdj(int level, int x, int y) {
        return board[level][x][y];
    }

    /**
     * Check if the level is valid according to the boundaries {@link #MAX_LEVEL} and {@link #MIN_LEVEL}.
     *
     * @param level int representing the number of level
     * @return  true if valid, false if not
     */
    public static boolean isLevelValid(int level) {
        if ((level < MIN_LEVEL) || (level > MAX_LEVEL)) {
            System.out.println("Sorry but " + level + " is not a legal choice.");
            return false;
        }
        return true;
    }

    /**
     * Determine if the input value size is within the boundary {@link #MAX_SIZE} and {@link #MIN_SIZE}.
     *
     * @param size  int representing the length of a row and height of a column in the board.
     * @return  true if valid, false if not
     */
    public static boolean isSizeValid(int size) {
        if ((size < MIN_SIZE) || (size > MAX_SIZE)) {
            System.out.println("Sorry but " + size + " is not a legal choice.");
            return false;
        }
        return true;
    }

    /**
     * Determine if there is a winner on the board.
     *
     * @param p1    @Player First player
     * @param p2    @Player Second player
     * @param scanner   @Scanner scanner to input value
     * @return      Whether the board has a winner or not
     */
    public boolean hasAWinner(Player p1, Player p2, Scanner scanner) {
        if (!p1.won(this) && !p2.won(this)) {
            System.out.print("Any key to continue to next round... ");
            scanner.next();
            System.out.println();
            return false;
        }
        return true;
    }

    /**
     * The String representation of the board
     *
     * @return  the string representation of the board.
     */
    public String toString() {
        String theBoard = "";
        for (int i = 0; i < board.length; i++) {
            theBoard += "Level " + i + "\n--------\n\t";
            for (int[] row : board[i]) {
                for (int column : row) {
                    theBoard += column + "\t";
                }
                theBoard += "\n\t";
            }
            theBoard += '\n';
        }
        return theBoard;
    }
}
