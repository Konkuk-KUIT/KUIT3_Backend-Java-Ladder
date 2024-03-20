package game.field;

public class FieldFactory {

    private FieldFactory(){

    }

    public static Ladder createLadder(int row,int col){
        Ladder ladder=new Ladder(row,col);
        return ladder;
    }

    public static Ladder createLadderAndRandomLadder(int row,int col,int randomCount){
        Ladder ladder=new Ladder(row,col,randomCount);
        return ladder;
    }
}
