package game;

import game.field.Field;
import game.field.FieldFactory;
import game.field.Ladder;

public class GameFactory {

    private GameFactory(){

    }

    public static LadderGame createLadderGameByRandom(int row,int col){
        int random= (int) (row*col*0.3);

        return new LadderGame(FieldFactory.createLadderAndRandomLadder(row,col,random));
    }

    public static LadderGame createLadderGame(int row,int col){
        return new LadderGame(FieldFactory.createLadder(row,col));
    }

}
