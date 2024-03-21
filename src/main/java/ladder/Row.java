package ladder;

public class Row {
    private Node[] row;

    public Row(NaturalNumber numberOfPerson) {
        row = new Node[numberOfPerson.get()];
        for (int i = 0; i < numberOfPerson.get(); i++) {
            row[i] = Node.of(Direction.NONE);
        }
    }

    public void drawLine(Position lineStartPosition) {
        validateLineStartPosition(lineStartPosition);
        row[lineStartPosition.get()].setGoRight();
        row[lineStartPosition.get() + 1].setGoLeft();
    }

    private void validateLineStartPosition(Position lineStartPosition) {
        if (lineStartPosition.get() < 0 || lineStartPosition.get() >= row.length - 1 ||
                row[lineStartPosition.get()].value() == Direction.LEFT ||
                row[lineStartPosition.get()].value() == Direction.RIGHT ||
                row[lineStartPosition.get() + 1].value() == Direction.RIGHT)
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LINE_START_POSITION.get());
    }

    public Position nextPosition(Position position) {
        if (isLeft(position))
            return position.prev();
        if (isRight(position))
            return position.next();
        return position;
    }

    private boolean isLeft(Position position) {
        return row[position.get()].value() == Direction.LEFT;
    }

    private boolean isRight(Position position) {
        return row[position.get()].value() == Direction.RIGHT;
    }

    public String printRow() {
        StringBuilder rowResult = new StringBuilder();
        for (Node node : row) {
            rowResult.append(node.value().get());
            rowResult.append(' ');
        }
        rowResult.append('\n');
        return rowResult.toString();
    }

    public int size() {
        return row.length;
    }
}
