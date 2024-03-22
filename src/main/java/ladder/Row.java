package ladder;

import java.util.Arrays;

public class Row {
    private Node[] row;

    public Row(int numberOfPerson) {
        validateNumberOfPerson(numberOfPerson);
        row = new Node[numberOfPerson];
        Arrays.fill(row, Node.parallelTo(Direction.NONE));
    }

    public void drawLine(Position lineStartPosition) {
        Node nodeFromStart = Node.parallelTo(Direction.RIGHT);
        validateOnRow(lineStartPosition);
        validateDrawable(lineStartPosition);
        row[lineStartPosition.getColNum()] = Node.parallelTo(Direction.RIGHT);
        row[lineStartPosition.getColNum() + 1] = Node.parallelTo(Direction.LEFT);
    }

    public Position nextPosition(Position position) {
        validateOnRow(position);
        return row[position.getColNum()].getNextPosition(position);
    }

    private void validateNumberOfPerson(int numberOfPerson) {
        if(numberOfPerson < 1) {
            throw new IllegalArgumentException("게임의 참여자 수는 1명 이상이어야 합니다.");
        }
    }

    private void validateDrawable(Position lineStartPosition) {
        Position expectedDestination = Position.at(lineStartPosition.getColNum()+1);
        validateOnRow(expectedDestination);
        if(row[lineStartPosition.getColNum()].hasDirection() ||
                row[expectedDestination.getColNum()].hasDirection()) {
            throw new IllegalArgumentException("라인 생성이 불가능한 위치 입니다.");
        }
    }

    private void validateOnRow(Position position) {
        if(position.getColNum() >= row.length || position.getColNum() < 0 ) {
            throw new IllegalArgumentException("유효하지 않은 위치 입니다.");
        }
    }
}
