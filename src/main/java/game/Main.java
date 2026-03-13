package game;

import game.player.TicTacToeGame;

import static game.player.TicTacToeGame.Status.InProgress;

public class Main {
    public static void main(String[] args) {

        Console.println("Welcome to Tic Tac Toe!");
        var playerX = Console.promptForPlayer(Token.X);
        var playerO = Console.promptForPlayer(Token.O);
        var game = new TicTacToeGame(playerX, playerO);

        while (game.getStatus() == InProgress) {

            var turnData = game.doNextTurn();

            Console.println("%s plays %s at %s %s".formatted(turnData.whoseTurn().name(), turnData.whoseTurn().token(), turnData.positionPlayed().row(), turnData.positionPlayed().col()));
            Console.showBoard(turnData.newBoardState());

            switch (game.getStatus()) {
                case Draw -> Console.println("It's a draw!");
                case XWins, OWins -> Console.println("%s wins!".formatted(turnData.whoseTurn().name()));
            }

        }
    }
    }

