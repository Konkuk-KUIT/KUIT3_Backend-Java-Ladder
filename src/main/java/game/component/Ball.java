package game.component;

public class Ball {

    private int row;
    private int col;

    public void initializePosition(int row,int col) {
        this.row=row;
        this.col=col;
    }

    public boolean canMoveDown(int row){
        return this.row<row;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void moveParallel(int ballNextCol) {
        this.col=ballNextCol;
    }

    public void moveVertical(int ballNextRow){
        this.row=ballNextRow;
    }
}
