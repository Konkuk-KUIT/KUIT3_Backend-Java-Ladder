package ladder;

import ladder.direction.Direction;
import ladder.exceptionMessage.ExceptionMessage;

import static ladder.direction.Direction.*;
import static ladder.exceptionMessage.ExceptionMessage.*;

public class Row {
    private int[] row;

    public Row(int numberOfPerson) {
        validateNumberOfPerson(numberOfPerson);
        row = new int[numberOfPerson];
    }

    public void drawLine(int lineStartPosition) {
        validateDrawLinePosition(lineStartPosition);
        row[lineStartPosition] = RIGHT.getDirection();        // 오른쪽
        row[lineStartPosition + 1] = LEFT.getDirection();     // 왼쪽
    }

    public int nextPosition(int position) {

        validatePosition(position);

        if (isLeft(position)) {
            return LEFT.getDirection();       // 왼쪽
        }
        if (isRight(position)) {
            return RIGHT.getDirection();      // 오른쪽
        }

        return position;
    }

    private boolean isLeft(int position) {
        return row[position] == -1;
    }

    private boolean isRight(int position) {
        return row[position] == 1;
    }

    private void validateNumberOfPerson(int numberOfPerson) {
        if(numberOfPerson < 1) {
            throw new IllegalArgumentException(NUMBER_OF_PERSON.getMessage());
        }
    }

    private void validateDrawLinePosition(int lineStartPosition) {
        if(lineStartPosition < 0 || lineStartPosition >= row.length - 1 || row[lineStartPosition] == -1 || row[lineStartPosition + 1] == 1) {
            throw new IllegalArgumentException(DRAWSLINE_POSITION.getMessage());
        }
    }

    private void validatePosition(int position) {
        if(position >= row.length || position < 0 ) {
            throw new IllegalArgumentException(POSITION.getMessage());
        }
    }




}
