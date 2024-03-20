package ladder;

public class Row {
    private int[] row;

    public enum Direction {
        RIGHT(1),
        LEFT(-1),
        NONE(0);

        private final int directionValue;

        Direction(int directionValue) {
            this.directionValue = directionValue;
        }
    }


    public enum ExceptionMessage {

        INVALID_LADDER_POSITION("유효하지 않은 위치 입니다."),
        INVALID_NUMBER_OF_PERSON("게임의 참여자 수는 1명 이상이어야 합니다."),
        INVALID_DRAW_LINE_POSITION("라인 생성이 불가능한 위치 입니다.");

        private String message;


        ExceptionMessage(String message) {
            this.message = message;
        }
    }

    public Row(int numberOfPerson) {
        validateNumberOfPerson(numberOfPerson);
        row = new int[numberOfPerson];
    }

    public void drawLine(int lineStartPosition) {
        validateDrawLinePosition(lineStartPosition);
        row[lineStartPosition] = Direction.RIGHT.directionValue;
        row[lineStartPosition + 1] = Direction.LEFT.directionValue;
    }

    public int nextPosition(int position) {

        validatePosition(position);

        if (isLeft(position)) {
            return position + Direction.LEFT.directionValue;
        }
        if (isRight(position)) {
            return position + Direction.RIGHT.directionValue;
        }

        return position;
    }

    private boolean isLeft(int position) {
        return row[position] == Direction.LEFT.directionValue;
    }

    private boolean isRight(int position) {
        return row[position] == Direction.RIGHT.directionValue;
    }

    private void validateNumberOfPerson(int numberOfPerson) {
        if (numberOfPerson < 1) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_OF_PERSON.message);
        }
    }

    private void validateDrawLinePosition(int lineStartPosition) {
        if (lineStartPosition < 0 || lineStartPosition >= row.length - 1 || row[lineStartPosition] == Direction.LEFT.directionValue || row[lineStartPosition + 1] == Direction.RIGHT.directionValue) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DRAW_LINE_POSITION.message);
        }
    }

    private void validatePosition(int position) {
        if (position >= row.length || position < 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LADDER_POSITION.message);
        }
    }


}
