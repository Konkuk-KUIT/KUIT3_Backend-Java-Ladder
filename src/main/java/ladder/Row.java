package ladder;

import static ladder.ExceptionMessage.*;

public class Row {
    private Node[] nodes;

    public static final int MINIMUM_NUMBER_OF_PERSON = 1;
    public static final int MAXIMUM_INVALID_POSITION_NUMBER = 0;

    public Row(NaturalNumber numberOfPerson) {
        validateNumberOfPerson(numberOfPerson.getValue());
        nodes = new Node[numberOfPerson.getValue()];
    }

    // 사다리 행에 가로선을 그리는 역할
    public void drawLine(Position lineStartPosition) {
        validateDrawLinePosition(lineStartPosition);
        nodes[lineStartPosition.getValue()] = Node.of(Direction.RIGHT);
        nodes[lineStartPosition.getValue() + 1] = Node.of(Direction.LEFT);
    }

    //현재위치 position에서 다음 위치를 계산해서 변환
    public Position nextPosition(Position currentPosition) {

        validatePosition(currentPosition);
        Position nextPosition = nodes[currentPosition.getValue()].move(currentPosition);
        return nextPosition;
    }

    private void validateNumberOfPerson(int numberOfPerson) {
        if(numberOfPerson < MINIMUM_NUMBER_OF_PERSON) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PERSON.getMessage());
        }
    }

    private void validateDrawLinePosition(Position lineStartPosition) {
        if(lineStartPosition.getValue() < MAXIMUM_INVALID_POSITION_NUMBER ||
                lineStartPosition.getValue() >= nodes.length - 1 ||
                nodes[lineStartPosition.getValue()].isLeft() ||
                nodes[lineStartPosition.getValue() + 1].isRight() ) {
            throw new IllegalArgumentException(INVALID_LINE_POSITION.getMessage());
        }
    }

    private void validatePosition(Position position) {
        if(position.getValue() >= nodes.length || position.getValue() < MAXIMUM_INVALID_POSITION_NUMBER ) {
            throw new IllegalArgumentException(INVALID_POSITION.getMessage());
        }
    }




}
