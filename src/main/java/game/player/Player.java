package game.player;

import game.Board;
import game.Token;

abstract public class Player {
    String name;
    Token token;

    public Player(String name, Token token){
        this.name = name;
        this.token = token;
    }

    public String name (){
        return name;
    }

    public Token token (){
        return token;
    }

    public abstract Position getNextMove(Board board);
}
