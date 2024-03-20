package ladder;

public class Row {
    private Node[] row;

    public Row(NaturalNumber numberOfPerson) {
        row = new Node[numberOfPerson.size()];
        for (int i = 0; i < numberOfPerson.size(); i++) {
            row[i] = new Node(0);
        }
    }

    public void drawLine(int lineStartPosition) {
        validateLineStartPosition(lineStartPosition);
        row[lineStartPosition].setGoRight();
        row[lineStartPosition + 1].setGoLeft();
    }

    public int nextPosition(int position) {
        validatePosition(position);
        if (isLeft(position))
            return position - 1;
        if (isRight(position))
            return position + 1;
        return position;
    }

    private boolean isLeft(int position) {
        return row[position].value() == -1;
    }

    private boolean isRight(int position) {
        return row[position].value() == 1;
    }

    public String printRow() {
        StringBuilder rowResult = new StringBuilder();
        for (Node node : row) {
            rowResult.append(String.valueOf(node.value()));
            rowResult.append(' ');
        }
        rowResult.append('\n');
        return rowResult.toString();
    }

    public void validatePosition(int position) {
        if (position < 0 || position >= row.length)
            throw new IllegalArgumentException("유효하지 않은 위치입니다.");
    }

    private void validateLineStartPosition(int lineStartPosition) {
        if (lineStartPosition < 0 || lineStartPosition >= row.length - 1 ||
                row[lineStartPosition].value() == -1 || row[lineStartPosition].value() == 1 ||
                row[lineStartPosition + 1].value() == 1)
            throw new IllegalArgumentException("라인 생성이 불가능한 위치입니다.");
    }
}
