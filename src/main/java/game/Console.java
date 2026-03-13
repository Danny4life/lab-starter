package game;

import game.player.*;

import java.text.ParseException;
import java.util.Scanner;

public class Console {

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Print a line of text
     */
    public static void println(String text) {
        System.out.println(text);
    }

    /**
     * Print an alert message
     */
    public static void printAlert(String text) {
        System.out.println("⚠ " + text);
    }

    /**
     * Prompt the user for an integer
     */
    public static int promptForInt(String prompt) {

        while (true) {
            System.out.print(prompt);

            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (Exception e) {
                printAlert("Please enter a valid number.");
            }
        }
    }

    /**
     * Prompt user to enter a board position
     */
    public static Position promptForPosition(String prompt, Board board) {

        while (true) {

            System.out.print(prompt);

            String input = scanner.nextLine();

            try {
                return Position.parse(input);
            } catch (ParseException e) {
                printAlert("Invalid position format. Try again.");
            }
        }
    }

    /**
     * Ask user which type of player to create
     */
    public static Player promptForPlayer(Token token) {

        println("Choose player type for " + token + ":");
        println("1 - Human");
        println("2 - Randy (Random AI)");
        println("3 - Linus (Sequential AI)");
        println("4 - Omola (Look-ahead AI)");

        int choice = promptForInt("Enter choice: ");

        return switch (choice) {
            case 2 -> new RandyPlayer(token);
            case 3 -> new LinusPlayer(token);
            case 4 -> new OmolaPlayer(token);
            default -> {
                System.out.print("Enter player name: ");
                String name = scanner.nextLine();
                yield new HumanPlayer(name, token);
            }
        };
    }

    /**
     * Display the board
     */
    public static void showBoard(Board board) {

        println("\nCurrent Board:");

        println("   1 2 3");

        String[] rowNames = {"T", "M", "B"};

        for (int i = 0; i < 3; i++) {

            System.out.print(rowNames[i] + "  ");

            for (int j = 0; j < 3; j++) {

                Position pos = new Position(Row.values()[i], Col.values()[j]);

                if (board.isEmptyAt(pos)) {
                    System.out.print(". ");
                } else {
                    Token token = board.getWinner().orElse(null);

                    Token[][] internal = getBoardState(board);

                    if (internal[i][j] == null)
                        System.out.print(". ");
                    else
                        System.out.print(internal[i][j] + " ");
                }
            }

            System.out.println();
        }

        println("");
    }

    /**
     * Helper method to access board state through reflection
     * (since board array is private)
     */
    private static Token[][] getBoardState(Board board) {

        try {
            var field = Board.class.getDeclaredField("board");
            field.setAccessible(true);
            return (Token[][]) field.get(board);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}