package ladder;

import java.util.Arrays;

public class Row {
    private Direction[] row;

    public Row(int numberOfPerson) {
        validateNumberOfPerson(numberOfPerson);
        row = new Direction[numberOfPerson];
        Arrays.fill(row, Direction.NONE);
    }

    public void drawLine(int lineStartPosition) {
        validateDrawLinePosition(lineStartPosition);
        row[lineStartPosition] = Direction.RIGHT;
        row[lineStartPosition + 1] = Direction.LEFT;
    }

    public int nextPosition(int position) {

        validatePosition(position);

        if (row[position].isLeft()) {
            return position - 1;
        }
        if (row[position].isRight()) {
            return position + 1;
        }

        return position;
    }

    private void validateNumberOfPerson(int numberOfPerson) {
        if(numberOfPerson < 1) {
            throw new IllegalArgumentException("게임의 참여자 수는 1명 이상이어야 합니다.");
        }
    }

    private void validateDrawLinePosition(int lineStartPosition) {
        if(lineStartPosition < 0 || lineStartPosition >= row.length - 1 || row[lineStartPosition].isLeft() || row[lineStartPosition + 1].isRight()) {
            throw new IllegalArgumentException("라인 생성이 불가능한 위치 입니다.");
        }
    }

    private void validatePosition(int position) {
        if(position >= row.length || position < 0 ) {
            throw new IllegalArgumentException("유효하지 않은 위치 입니다.");
        }
    }




}
