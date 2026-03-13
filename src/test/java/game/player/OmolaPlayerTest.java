package game.player;

import game.Board;
import game.Col;
import game.Token;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OmolaPlayerTest {

    @Test
    void omolaBlocksOpponent(){

        Board board = new Board("""
                OO-
                X--
                ---
                """);

        Player omola = new OmolaPlayer(Token.X);

        Position move = omola.getNextMove(board);

        Position expected = new Position(Row.Top, Col.Right);

        assertEquals(expected, move);
    }

}