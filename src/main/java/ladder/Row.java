package ladder;

import static ladder.ExceptionMessage.*;

public class Row {
    private Node[] nodes;

    public Row(int numberOfPerson) {
        validateNumberOfPerson(numberOfPerson);
        nodes = new Node[numberOfPerson];
        for(int i = 0; i < numberOfPerson; i++) {
            nodes[i] = Node.of(Direction.NONE);
        }
    }

    public void drawLine(Position lineStartPosition) {
        validateDrawLinePosition(lineStartPosition);

        setDirectionAtPosition(lineStartPosition, Direction.RIGHT);
        setDirectionAtPosition(lineStartPosition.next(), Direction.LEFT);
    }

    public Position nextPosition(Position currentPosition) {
        validatePosition(currentPosition);
        return nodes[currentPosition.getValue()].move(currentPosition);
    }

    private void setDirectionAtPosition(Position position, Direction direction) {
        nodes[position.getValue()] = Node.of(direction);
    }

    private void validateNumberOfPerson(int numberOfPerson) {
        if(numberOfPerson < 1) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PERSON.getMessage());
        }
    }

    private void validateDrawLinePosition(Position lineStartPosition) {
        if(isInvalidDrawPosition(lineStartPosition)
                || nodes[lineStartPosition.getValue()].isRight()
                || nodes[lineStartPosition.next().getValue()].isRight()
                || nodes[lineStartPosition.getValue()].isLeft()) {
            throw new IllegalArgumentException(INVALID_DRAW_POSITION.getMessage());
        }
    }

    private void validatePosition(Position position) {
        if(position.isBiggerThan(nodes.length - 1) || position.isSmallerThan(0) ) {
            throw new IllegalArgumentException(INVALID_POSITION.getMessage());
        }
    }

    private boolean isInvalidDrawPosition(Position lineStartPosition) {
        return lineStartPosition.isBiggerThan(nodes.length - 2) || lineStartPosition.isSmallerThan(0);
    }




}
