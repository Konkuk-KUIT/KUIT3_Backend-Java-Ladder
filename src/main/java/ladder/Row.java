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
            return position +Direction.LEFT.directionValue;
        }
        if (isRight(position)) {
            return position +Direction.RIGHT.directionValue;
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
        if(numberOfPerson < 1) {
            throw new IllegalArgumentException("게임의 참여자 수는 1명 이상이어야 합니다.");
        }
    }

    private void validateDrawLinePosition(int lineStartPosition) {
        if(lineStartPosition < 0 || lineStartPosition >= row.length - 1 || row[lineStartPosition] == Direction.LEFT.directionValue || row[lineStartPosition + 1] == Direction.RIGHT.directionValue) {
            throw new IllegalArgumentException("라인 생성이 불가능한 위치 입니다.");
        }
    }

    private void validatePosition(int position) {
        if(position >= row.length || position < 0 ) {
            throw new IllegalArgumentException("유효하지 않은 위치 입니다.");
        }
    }




}
