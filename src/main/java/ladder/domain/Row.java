package ladder.domain;

import static ladder.exception.ExceptionMessage.*;

public class Row {

    // Node들로 이루어진 한 행
    private Node[] row;

    // 사람 수만큼의 node를 가진 행 생성
    public Row(NaturalNumber numberOfPerson) {
        row = new Node[numberOfPerson.getNum()];
        // 초기화
        for (int i = 0; i < numberOfPerson.getNum(); i++) {
            row[i] = Node.of(Direction.NONE);
        }
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
        validatePosition(position);
        Position newPosition = row[position.getValue()].move(position);
        // 새로운 위치가 유효한지 검증
        validatePosition(newPosition);
        return newPosition;
    }


    // 유효성 검증
    private void validateDrawLinePosition(Position position) {
        if(isInvalidDrawPosition(position) && isSameLine(position)){
            throw new IllegalArgumentException(INVALID_ROW_POSITION.getMessage());
        }
    }

    private boolean isInvalidDrawPosition(Position position){
        return position.isBiggerThan(row.length - 2) || position.isSmallerThan(0);
    }

    // 중복 라인 체크
    private boolean isSameLine(Position position){
        return (row[position.getValue()].isLeft()
                || row[position.nextPosition().getValue()].isRight()
                || row[position.getValue()].isRight());
    }

    private void validatePosition(Position position){
        if(isInvalidPosition(position)) {
            throw new IllegalArgumentException(INVALID_LADDER_POSITION.getMessage());
        }
    }

    private boolean isInvalidPosition(Position position) {
        return position.isBiggerThan(row.length - 1) || position.isSmallerThan(0);
    }

}
