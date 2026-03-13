package game.player;

import game.Board;
import game.Token;

import java.util.List;

public class LinusPlayer extends Player {
    public LinusPlayer(Token token){
        super("Linus", token);
    }

    @Override
    public Position getNextMove(Board board){

        var emptyCells = board.getEmptyCells();

        return emptyCells.get(0);
    }
}
