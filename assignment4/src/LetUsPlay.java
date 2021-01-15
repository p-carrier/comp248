// -------------------------------------------------------
// Assignment 4
// Written by: Philippe Carrier  -  id 40153985
// For COMP 248 Section P – Fall 2019
// --------------------------------------------------------

import java.util.Random;
import java.util.Scanner;

/**
 * Program that let two players play a game of 3D Warrior Game. It starts by creating either a
 * normal or custom {@link @Board}. Then, it creates two instances of {@link @Player} and randomly
 * decide which one will go first. Once the setup is ready, the game can begin.
 *
 * @author Philippe Carrier
 * @since 12/01/2019
 */

public class LetUsPlay {

    public static void main(String[] args) {

//        scanner to input value
        Scanner scanner = new Scanner(System.in);
//        the dice for the game
        Dice dice = new Dice();
//        the board for the game
        Board board;

        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println("*                                                 *");
        System.out.println("*       WELCOME to Nancy's 3D Warrior Game!       *");
        System.out.println("*                                                 *");
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println();

        board = boardCreation(scanner);

        System.out.println();
        System.out.println("Your 3D board has been set up and looks like this:");
        System.out.println();
        System.out.println(board.toString());

        Player[] players = playerCreation(scanner);
        System.out.println("The game has started "
                + players[0].getName()
                + " goes first");
        System.out.println("===================================");
        System.out.println();

//        the whole game procedure
        do {
            for(int i = 0; i < players.length; i++) {
                players[i].turn(players[(i == 0 ? 1 : 0)], dice, board, scanner);
            }

            System.out.println();
            System.out.println("At the end of this round:");
            System.out.println(players[0].toString());
            System.out.println(players[1].toString());

        } while(!board.hasAWinner(players[0], players[1], scanner));

        System.out.println();
        System.out.println("The winner is player " +
                (players[0].won(board) ? players[0].getName() : players[1].getName())
                + ". Well done!!!");

        System.out.println();
        System.out.println("End of Nancy's 3D Warrior Game!");
        scanner.close();
    }

    /**
     * Steps to create the players and decides which one will start the game
     *
     * @param scanner   @Scanner scanner to input value
     * @return @Player[] array contains the two players that are going to play the game
     */
    public static Player[] playerCreation(Scanner scanner) {
//        to get random values
        Random random = new Random();
        Player[] players = new Player[2];

        System.out.print("What is player 0's name (one word only): ");
        String name = scanner.next();
        Player player0 = new Player();
        player0.setName(name);

        System.out.print("What is player 1's name (one word only): ");
        name = scanner.next();
        Player player1 = new Player(name);

        if (random.nextInt(2) == 0) {
            players[0] = player0;
            players[1] = player1;
        } else {
            players[0] = player1;
            players[1] = player0;
        }

        return players;
    }

    /**
     * Steps to create the board for the game
     *
     * @param scanner   @Scanner scanner to input value
     * @return  @Board the board for the game
     */
    public static Board boardCreation(Scanner scanner) {
        System.out.println("The default game board has 3 levels and each level has a 4x4 board.");
        System.out.println("You can use this default board size or change the size");
        System.out.println("\t0 to use the default board size");
        System.out.println("\t-1 to enter your own size");
        System.out.print("==> What do you want to do? ");

        if (Player.decision(scanner, -1, 0) == 0) {
            return new Board();
        } else {
            System.out.print("How many levels would you like? (minimum size 3, max 10) ");
            int level;
            do {
                level = scanner.nextInt();
            } while (!Board.isLevelValid(level));

            System.out.println("What size do you want the nxn boards on each level to be?");
            System.out.println("Minimum size is 3x3, max is 10x10");
            System.out.print("==> Enter the value of n: ");
            int size;
            do {
                size = scanner.nextInt();
            } while (!Board.isSizeValid(size));

            return new Board(level,size);
        }
    }
}
