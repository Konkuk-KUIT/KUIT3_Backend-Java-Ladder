package ladder;

public class Row {
    private int[] row;

    public Row(int numberOfPerson) {
        validateNumberOfPerson(numberOfPerson);
        row = new int[numberOfPerson];
    }

    public void drawLine(int lineStartPosition) {
        validateDrawLinePosition(lineStartPosition);
        row[lineStartPosition] = Direction.RIGHT.getValue();
        row[lineStartPosition + 1] = Direction.LEFT.getValue();
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
        return row[position] == Direction.LEFT.getValue();
    }

    private boolean isRight(int position) {
        return row[position] == Direction.RIGHT.getValue();
    }

    private void validateNumberOfPerson(int numberOfPerson) {
        if(numberOfPerson < 1) {
            throw new IllegalArgumentException("게임의 참여자 수는 1명 이상이어야 합니다.");
        }
    }

    private void validateDrawLinePosition(int lineStartPosition) {
        if(isInvalidPosition(lineStartPosition) ||
                isLineAtPosition(lineStartPosition) ||
                isLineAtPrevPosition(lineStartPosition) ||
                isLineAtNextPosition(lineStartPosition)) {
            throw new IllegalArgumentException("라인 생성이 불가능한 위치 입니다.");
        }
    }

    private void validatePosition(int position) {
        if(position >= row.length || position < 0 ) {
            throw new IllegalArgumentException("유효하지 않은 위치 입니다.");
        }
    }

    private boolean isInvalidPosition(int lineStartPosition) {
        return lineStartPosition < 0 || lineStartPosition >= row.length - 1;
    }

    private boolean isLineAtPosition(int lineStartPosition) {
        return row[lineStartPosition] == Direction.RIGHT.getValue() || row[lineStartPosition + 1] == Direction.LEFT.getValue();
    }

    private boolean isLineAtNextPosition(int lineStartPosition) {
        return row[lineStartPosition + 1] == Direction.RIGHT.getValue();
    }

    private boolean isLineAtPrevPosition(int lineStartPosition) {
        return row[lineStartPosition] == Direction.LEFT.getValue();
    }




}
