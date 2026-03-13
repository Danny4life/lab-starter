package game.player;

import game.Board;
import game.Token;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandyPlayerTest {

    @Test
    void randyChoosesEmptyCell(){

        Board board = new Board("""
                XOX
                -XO
                --O
                """);

        Player randy = new RandyPlayer(Token.X);

        Position move = randy.getNextMove(board);

        assertTrue(board.getEmptyCells().contains(move));
    }
}