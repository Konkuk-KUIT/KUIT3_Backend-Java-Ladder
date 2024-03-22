package ladder;

import ladder.exception.ExceptionMessage;

import java.awt.*;

public class Row {
    private Node[] row;



    public Row(NaturalNumber numberOfPerson) {
        validateNumberOfPerson(numberOfPerson);
        row = new Node[numberOfPerson.get()];
        for (int i = 0; i < numberOfPerson.get(); i++) {
            row[i] = Node.of(Direction.NONE);
        }
    }

    public void drawLine(Position lineStartPosition) {
        validateDrawLinePosition(lineStartPosition);
        row[lineStartPosition.getPosition()] = Node.of(Direction.LEFT);
        row[lineStartPosition.getPosition() + 1] = Node.of(Direction.RIGHT);
    }



    public Position nextPosition(Position currentPosition) {

        validatePosition(currentPosition);
        Position nextPosition = row[currentPosition.getValue()].move(currentPosition);
        validatePosition(nextPosition);
        return nextPosition;

    }

    public boolean isLineDrawn(int j) {
        return row[j].isRight();
    }



    private void validateNumberOfPerson(NaturalNumber numberOfPerson) {
        if (numberOfPerson.get() < 1) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_OF_PERSON.getMessage());
        }
    }

    private void validateDrawLinePosition(Position lineStartPosition) {
        if (lineStartPosition.getPosition() < 0 || lineStartPosition.getPosition() >= row.length - 1 || row[lineStartPosition.getPosition()] ==  Node.of(Direction.LEFT) || row[lineStartPosition.getPosition() + 1] ==  Node.of(Direction.RIGHT) ) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DRAW_LINE_POSITION.getMessage());
        }
    }

    private void validatePosition(Position position) {
        if (isInvalidPosition(position)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LADDER_POSITION.getMessage());
        }
    }

    private boolean isInvalidPosition(Position position) {
        return position.isBiggerThan(row.length - 1) || position.isSmallerThan(0);
    }


}
