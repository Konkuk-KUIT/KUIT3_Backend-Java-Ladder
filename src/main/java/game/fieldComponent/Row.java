package game.fieldComponent;

import game.component.Pipe;
import game.exception.CustomException;
import game.exception.ErrorCode;
import game.component.util.PipeConstant;

import java.util.stream.IntStream;

public class Row {
    private Pipe[] row;

    public Row(int numberOfPerson) {
        validateNumberOfPerson(numberOfPerson);
        row= new Pipe[numberOfPerson];
        IntStream.range(0, numberOfPerson).forEach(i -> row[i] = new Pipe());

    }

    public void drawLine(int lineStartPosition) {
        validateDrawLinePosition(lineStartPosition);

        row[lineStartPosition].setPipeStatusRight();
        row[lineStartPosition + PipeConstant.COL_BLOCK_SIZE].setPipeStatusLeft();
    }

    public int nextPosition(int position) {

        validatePosition(position);
        return position+row[position].getMoveWeight();
    }


    private void validateNumberOfPerson(int numberOfPerson) {
        if(numberOfPerson < 1) {
            throw new CustomException(ErrorCode.LACK_PARTICIPANTS);
        }
    }

    private void validateDrawLinePosition(int lineStartPosition) {
        if(lineStartPosition < PipeConstant.START_INDEX || lineStartPosition >= row.length - 1 ||
                row[lineStartPosition].isLeftExtended()||row[lineStartPosition+PipeConstant.COL_BLOCK_SIZE].isRightExtended()) {
            throw new CustomException(ErrorCode.INVALID_LINE_POSITION);
        }
    }

    private void validatePosition(int position) {
        if(position >= row.length || position < PipeConstant.START_INDEX ) {
            throw new CustomException(ErrorCode.INVALID_POSITION);
        }
    }


}
