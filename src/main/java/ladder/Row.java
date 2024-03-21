package ladder;

import java.util.Arrays;

import static ladder.ExceptionMessage.*;

public class Row {
    private Node[] row;

    public Row(NaturalNumber numberOfPerson) {
        row = new Node[numberOfPerson.get()];
        for (int i = 0; i < row.length; i++) {
            row[i] = Node.of(Direction.NONE);
        }
    }

    public void drawLine(Position lineStartPosition) {
        validateDrawLinePosition(lineStartPosition);
        row[lineStartPosition.getPosition()] = Node.of(Direction.RIGHT);
        row[lineStartPosition.getPosition() + 1] = Node.of(Direction.LEFT);
    }

    public Position nextPosition(Position currentPosition) {
        validatePosition(currentPosition);
        return row[currentPosition.getPosition()].move(currentPosition);
    }

    private void validateNumberOfPerson(NaturalNumber numberOfPerson) {
        if(numberOfPerson.get() <= 1) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PERSON.getMessage());
        }
    }

    private void validateDrawLinePosition(Position lineStartPosition) {
        if(lineStartPosition.getPosition() < 0 || lineStartPosition.getPosition() >= row.length - 1
                || row[lineStartPosition.getPosition()].getDirection() == Direction.LEFT || row[lineStartPosition.getPosition() + 1].getDirection() == Direction.RIGHT) {
            throw new IllegalArgumentException(INVALID_DRAW_POSITION.getMessage());
        }
    }

    private void validatePosition(Position position) {
        if(position.getPosition() >= row.length || position.getPosition() < 0 ) {
            throw new IllegalArgumentException(INVALID_POSITION.getMessage());
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Node node : row) { // 'nodes'는 이 Row가 가지고 있는 Node 객체들의 배열이라고 가정
            if (node.getDirection() == Direction.RIGHT) {
                builder.append("1  ");
            } else if (node.getDirection() == Direction.LEFT) {
                builder.append("-1  ");
            } else {
                builder.append("0  ");
            }
        }
        return builder.toString();
    }

}
