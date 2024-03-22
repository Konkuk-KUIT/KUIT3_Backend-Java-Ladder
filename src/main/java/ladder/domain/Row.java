package ladder.domain;

import static ladder.exception.ExceptionMessage.*;

public class Row {
    private Node[] row;

    public Row(NaturalNumber numberOfPerson) {
        validateNumberOfPerson(numberOfPerson.getNum());
        row = new Node[numberOfPerson.getNum()];
    }

    public void drawLine(Position lineStartPosition) {
        validateDrawLinePosition(lineStartPosition);

        Position next = lineStartPosition.nextPosition();
        row[lineStartPosition.getValue()] = Node.of(Direction.RIGHT);
        row[next.getValue()] = Node.of(Direction.LEFT);
    }

    public Position nextPosition(int position) {

        validatePosition(position);

        if (isLeft(position)) {
//            return row[position.getValue()].move(position);
            return position + Direction.LEFT;
        }
        if (isRight(position)) {
            return position + Direction.RIGHT;
        }

        return position;
    }

    private boolean isLeft(int position) {
        return row[position] == -1;
    }

    private boolean isRight(int position) {
        return row[position] == 1;
    }

    private void validateNumberOfPerson(int numberOfPerson) {
        if(numberOfPerson < 1) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PERSON.getMessage());
        }
    }

    private void validateDrawLinePosition(Position lineStartPosition) {
        if(lineStartPosition < 0 || lineStartPosition >= row.length - 1 || row[lineStartPosition] == -1 || row[lineStartPosition + 1] == 1) {
            throw new IllegalArgumentException(INVALID_ROW_POSITION.getMessage());
        }
    }



}
