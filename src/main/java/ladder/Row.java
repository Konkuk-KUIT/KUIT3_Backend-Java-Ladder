package ladder;

import static ladder.ExceptionMessage.*;


public class Row {
    private Node[] nodes;

    public Row(NaturalNumber numberOfPerson) {
        nodes = new Node[numberOfPerson.getNumber()];
        for (int i = 0; i < numberOfPerson.getNumber(); i++) {
            nodes[i] = Node.of(Direction.NONE);
        }
    }

    public void drawLine(Position startPosition) {
        validateDrawLinePosition(startPosition);
        setDirectionAtPosition(startPosition, Direction.RIGHT);
        setDirectionAtPosition(startPosition.next(), Direction.LEFT);
    }

    private void setDirectionAtPosition(Position startPosition, Direction direction) {
        nodes[startPosition.getValue()] = Node.of(direction);
    }

    private void validateDrawLinePosition(Position startPosition) {
        if (isInvalidDrawPosition(startPosition) || isDuplicatedDrawPosition(startPosition)) {
            throw new IllegalArgumentException(INVALID_DRAW_LINE_POSITION.getMessage());
        }
    }

    private boolean isDuplicatedDrawPosition(Position position) {
        return (nodes[position.getValue()].isRight()
                || nodes[position.next().getValue()].isRight()
                || nodes[position.getValue()].isLeft());
    }

    public Position nextPosition(Position currentPosition) {
        isInvalidNextPosition(currentPosition);
        return nodes[currentPosition.getValue()].move(currentPosition);
    }

    private boolean isInvalidDrawPosition(Position position) {
        if (position.isBiggerThan(nodes.length - 2) || position.isSmallerThan(0)) {
            throw new IllegalArgumentException(INVALID_DRAW_LINE_POSITION.getMessage());
        }
        return false;
    }

    private void isInvalidNextPosition(Position position) {
        if (position.isBiggerThan(nodes.length - 1) || position.isSmallerThan(0)) {
            throw new IllegalArgumentException(INVALID_POSITION.getMessage());
        }
    }


//    public String printRow(Position currentPosition) {
//        StringBuilder rowRepresentation = new StringBuilder();
//        for (int i = 0; i < nodes.length; i++) {
//            rowRepresentation.append(i == currentPosition.getValue() ? "*" : " ");
//            rowRepresentation.append(nodes[i].isRight() ? " -1 " : nodes[i].isLeft() ? " 1 " : " 0 ");
//        }
//        return rowRepresentation.toString();
//    }
}