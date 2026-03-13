package game.player;

import game.Board;
import game.Token;

import java.util.List;
import java.util.Random;

public class RandyPlayer extends Player{
    Random random = new Random();

    public RandyPlayer(Token token){
        super("Randy", token);
    }

    @Override
    public Position getNextMove(Board board){

        var emptyCells = board.getEmptyCells();

        return emptyCells.get(random.nextInt(emptyCells.size()));
    }
}
