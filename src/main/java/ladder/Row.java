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
                row[lineStartPosition.get()].get() == Direction.LEFT ||
                row[lineStartPosition.get()].get() == Direction.RIGHT ||
                row[lineStartPosition.get() + 1].get() == Direction.RIGHT)
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LINE_START_POSITION.get());
    }

    public Position move(Position position) {
        if (row[position.get()].isLeft())
            return position.prev();
        if (row[position.get()].isRight())
            return position.next();
        return position;
    }

    public String printRow() {
        StringBuilder rowResult = new StringBuilder();
        for (Node node : row) {
            rowResult.append(node.get().get());
            rowResult.append(' ');
        }
        rowResult.append('\n');
        return rowResult.toString();
    }

    public int size() {
        return row.length;
    }
}
