package ladder.domain;

import static ladder.exception.ExceptionMessage.*;

public class Row {

    // Node들로 이루어진 한 행
    private Node[] row;

    // 사람 수만큼의 node를 가진 행 생성
    public Row(NaturalNumber numberOfPerson) {
        row = new Node[numberOfPerson.getNum()];
    }

    // 사다리 그리기
    public void drawLine(Position lineStartPosition) {
        validateDrawLinePosition(lineStartPosition);

        Position next = lineStartPosition.nextPosition();
        row[lineStartPosition.getValue()] = Node.of(Direction.RIGHT);
        row[next.getValue()] = Node.of(Direction.LEFT);
    }

    // 다음 position으로 이동
    public Position nextPosition(Position position) {
        validateNextPosition(position);
        return row[position.getValue()].move(position);
    }


    // 유효성 검증
    private void validateDrawLinePosition(Position lineStartPosition) {
        if(lineStartPosition.getValue() >= row.length - 1 || row[lineStartPosition.getValue()] == Direction.LEFT || row[lineStartPosition.nextPosition().getValue()] == 1) {
            throw new IllegalArgumentException(INVALID_ROW_POSITION.getMessage());
        }
    }

    public boolean validateNextPosition(Position position){
        if()
    }

}
