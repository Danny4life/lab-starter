package game.player;

import game.Board;
import game.Token;

import java.util.List;

public class OmolaPlayer extends Player {
    public OmolaPlayer(Token token) {
        super("Omola", token);
    }

    @Override
    public Position getNextMove(Board board) {

        List<Position> empty = board.getEmptyCells();

        // 1️⃣ check for winning move
        for (Position pos : empty) {

            Board copy = new Board(board);
            copy.place(pos, token);

            if (copy.getWinner().isPresent() && copy.getWinner().get() == token) {
                return pos;
            }
        }

        // 2️⃣ block opponent
        Token opponent = token == Token.X ? Token.O : Token.X;

        for (Position pos : empty) {

            Board copy = new Board(board);
            copy.place(pos, opponent);

            if (copy.getWinner().isPresent() && copy.getWinner().get() == opponent) {
                return pos;
            }
        }

        // 3️⃣ otherwise pick first
        return empty.get(0);
    }
}
