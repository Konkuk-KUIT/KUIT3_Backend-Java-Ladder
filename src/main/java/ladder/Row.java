package ladder;

public class Row {
    private static final int RIGHT = 1;
    private static final int LEFT = -1;
    private static final String ERROR_INVALID_NUMBER_OF_PERSON = "참여 인원은 1명 이상이어야 합니다.";
    private static final String ERROR_INVALID_LINE_CREATE_POSITION = "라인 생성이 불가능한 위치 입니다.";
    private static final String ERROR_INVALID_POSITION = "유효하지 않은 위치 입니다.";

    private int[] row;

    public Row(int numberOfPerson) {
        validateNumberOfPerson(numberOfPerson);
        row = new int[numberOfPerson];
    }

    public void drawLine(int lineStartPosition) {
        validateDrawLinePosition(lineStartPosition);
        row[lineStartPosition] = RIGHT;
        row[lineStartPosition + 1] = LEFT;
    }

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
        return row[position] == LEFT;
    }

    private boolean isRight(int position) {
        return row[position] == RIGHT;
    }

    private void validateNumberOfPerson(int numberOfPerson) {
        if(numberOfPerson < 1) {
            throw new IllegalArgumentException(ERROR_INVALID_NUMBER_OF_PERSON);
        }
    }

    private void validateDrawLinePosition(int lineStartPosition) {
        if(lineStartPosition < 0 || lineStartPosition >= row.length - 1 || row[lineStartPosition] == LEFT || row[lineStartPosition + 1] == RIGHT) {
            throw new IllegalArgumentException(ERROR_INVALID_LINE_CREATE_POSITION);
        }
    }

    private void validatePosition(int position) {
        if(position >= row.length || position < 0 ) {
            throw new IllegalArgumentException(ERROR_INVALID_POSITION);
        }
    }
}