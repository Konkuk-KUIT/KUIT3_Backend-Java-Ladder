package game.fieldComponent;

import game.component.Ball;
import game.component.Pipe;
import game.exception.CustomException;
import game.exception.ErrorCode;
import game.component.util.PipeConstant;

import java.util.stream.IntStream;

public class Row {
    private Pipe[] pipes;

    public Row(int numberOfPerson) {
        validateNumberOfPerson(numberOfPerson);
        pipes = new Pipe[numberOfPerson];
        IntStream.range(0, numberOfPerson).forEach(i -> pipes[i] = new Pipe());

    }

    public void drawLine(int lineStartPosition) {
        validateDrawLinePosition(lineStartPosition);

        pipes[lineStartPosition].setPipeStatusRight();
        pipes[lineStartPosition + PipeConstant.COL_BLOCK_SIZE].setPipeStatusLeft();
    }

    public int nextPosition(int position) {

        validatePosition(position);
        return position+ pipes[position].getMoveWeight();
    }
    public boolean canExtend(int position){
        if(isAlreadyExtend(position))
            return false;
        try {
            validateDrawLinePosition(position);
        }
        catch(Exception e){
            return false;
        }
        return true;
    }
    public boolean isAlreadyExtend(int position){
        return pipes[position].getMoveWeight()!=0;
    }
    private void validateNumberOfPerson(int numberOfPerson) {
        if(numberOfPerson < 1) {
            throw new CustomException(ErrorCode.LACK_PARTICIPANTS);
        }
    }

    private void validateDrawLinePosition(int lineStartPosition) {
        if(lineStartPosition < PipeConstant.START_INDEX || lineStartPosition >= pipes.length - 1 ||
                pipes[lineStartPosition].isLeftExtended()|| pipes[lineStartPosition+PipeConstant.COL_BLOCK_SIZE].isRightExtended()) {
            throw new CustomException(ErrorCode.INVALID_LINE_POSITION);
        }
    }

    private void validatePosition(int position) {
        if(position >= pipes.length || position < PipeConstant.START_INDEX ) {
            throw new CustomException(ErrorCode.INVALID_POSITION);
        }
    }

    public void print(Ball ball,int row) {
        for(int i=0;i<pipes.length;i++){
            System.out.printf("%2d",pipes[i].getMoveWeight());
            System.out.printf("%s",getBallStringIfSamePosition(ball,row,i));
        }
        System.out.println();
    }
    public String getBallStringIfSamePosition(Ball ball,int row,int col){
        if(ball.getRow()==row&&ball.getCol()==col)
            return "*";
        return " ";
    }
}
