package model;

public class LadderPosition {
    private final Position row;
    private final Position col;

    public LadderPosition(Position row, Position col) {
        this.row = row;
        this.col = col;
    }

    public Position getCol() {
        return col;
    }
    public Position getRow(){
        return row;
    }
    public static LadderPosition of(Position row, Position col){
        LadderPosition lp = new LadderPosition(row,col);
        return lp;
    }
}
