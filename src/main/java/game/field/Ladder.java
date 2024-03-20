package game.field;

import game.component.Ball;
import game.component.util.PipeConstant;
import game.component.util.PipeStatus;
import game.exception.CustomException;
import game.exception.ErrorCode;
import game.field.util.LadderConstant;
import game.fieldComponent.Row;

public class Ladder implements Field {

    private Row[] rows;
    private Ball ball;

    public Ladder(int numberOfRows, int numberOfPerson) {
        rows = new Row[numberOfRows];
        ball=new Ball();
        for(int i = 0; i < numberOfRows; i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    public void drawLine(int row, int col) {
        rows[row].drawLine(col);
    }


    @Override
    public int run(int... position) {
        validateBallPosition(position[0],position[1]);
        ball.initializePosition(position[0],position[1]);

        while(canMove(ball)){
            ball.moveParallel(getBallNextCol());
            ball.moveVertical(getBallNextRow());
        }
        return ball.getCol();
    }
    public int runWithPrint(int... position) {
        validateBallPosition(position[0],position[1]);
        ball.initializePosition(position[0],position[1]);

        while(canMove(ball)){
            System.out.println("Before");
            print();
            ball.moveParallel(getBallNextCol());

            System.out.println("After");
            print();
            ball.moveVertical(getBallNextRow());
            System.out.println();
        }
        return ball.getCol();
    }

    public void print(){
        for(int i=0;i<rows.length;i++){
            rows[i].print(ball,i);
        }
    }
    private void validateBallPosition(int row,int col){
        if(row<0||row>=rows.length)
            throw new CustomException(ErrorCode.INVALID_POSITION);
    }
    private int getBallNextCol(){
        return rows[ball.getRow()].nextPosition(ball.getCol());
    }

    private int getBallNextRow(){
        return ball.getRow()+LadderConstant.ROW_BLOCK_SIZE;
    }
    private boolean canMove(Ball ball){
        return ball.canMoveDown(rows.length);
    }


}
