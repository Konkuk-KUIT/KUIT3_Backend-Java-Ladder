package ladder;

import java.util.Arrays;

public class Row {
    private Node[] row;

    public Row(int numberOfPerson) {
        validateNumberOfPerson(numberOfPerson);
        row = new Node[numberOfPerson];
        Arrays.fill(row, Node.parallelTo(Direction.NONE));
    }

    public void drawLine(int lineStartPosition) {
        validateDrawLinePosition(lineStartPosition);
        row[lineStartPosition] = Node.parallelTo(Direction.RIGHT);
        row[lineStartPosition + 1] = Node.parallelTo(Direction.LEFT);
    }

    public Position nextPosition(Position position) {
        validatePosition(position);
        Position newPosition = row[position.getColNum()].getNextPosition(position);
        validatePosition(newPosition);
        return newPosition;
    }

    private void validateNumberOfPerson(int numberOfPerson) {
        if(numberOfPerson < 1) {
            throw new IllegalArgumentException("게임의 참여자 수는 1명 이상이어야 합니다.");
        }
    }

    private void validateDrawLinePosition(int lineStartPosition) {
        if(lineStartPosition < 0 || lineStartPosition >= row.length - 1
                || row[lineStartPosition].hasDirection() || row[lineStartPosition + 1].hasDirection()) {
            throw new IllegalArgumentException("라인 생성이 불가능한 위치 입니다.");
        }
    }

    private void validatePosition(Position position) {
        if(position.getColNum() >= row.length || position.getColNum() < 0 ) {
            throw new IllegalArgumentException("유효하지 않은 위치 입니다.");
        }
    }
}
