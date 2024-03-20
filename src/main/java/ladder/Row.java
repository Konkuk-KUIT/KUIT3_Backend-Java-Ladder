package ladder;

import static ladder.ExceptionMessage.*;

public class Row {
    private int[] row;

    public static final int MINIMUM_NUMBER_OF_PERSON = 1;
    public static final int MAXIMUM_INVALID_POSITION_NUMBER = 0;

    public Row(int numberOfPerson) {
        validateNumberOfPerson(numberOfPerson);
        row = new int[numberOfPerson];
    }

    // 사다리 행에 가로선은 그리는 역할
    public void drawLine(int lineStartPosition) {
        validateDrawLinePosition(lineStartPosition);
        row[lineStartPosition] = Direction.RIGHT.getValue();
        row[lineStartPosition + 1] = Direction.LEFT.getValue();
    }

    //현재위치 position에서 다음 위치를 계산해서 변환
    public int nextPosition(int position) {

        validatePosition(position);

        if (isLeft(position)) {
            return position - 1;
        }
        if (isRight(position)) {
            return position + 1;
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
        if(numberOfPerson < MINIMUM_NUMBER_OF_PERSON) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PERSON.getMessage());
        }
    }

    private void validateDrawLinePosition(int lineStartPosition) {
        if(lineStartPosition < MAXIMUM_INVALID_POSITION_NUMBER || lineStartPosition >= row.length - 1 || row[lineStartPosition] == Direction.LEFT.getValue() || row[lineStartPosition + 1] == Direction.RIGHT.getValue()) {
            throw new IllegalArgumentException(INVALID_LINE_POSITION.getMessage());
        }
    }

    private void validatePosition(int position) {
        if(position >= row.length || position < MAXIMUM_INVALID_POSITION_NUMBER ) {
            throw new IllegalArgumentException(INVALID_POSITION.getMessage());
        }
    }




}
