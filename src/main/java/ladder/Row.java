package ladder;

public class Row {
    private Node[] row;

    public Row(int numberOfPerson) {
        validateNumberOfPerson(numberOfPerson);
        row = new Node[numberOfPerson];
    }

    public void drawLine(int lineStartPosition) {
        validateDrawLinePosition(lineStartPosition);
        //row[lineStartPosition] = Direction.RIGHT.getDirection();
        //row[lineStartPosition + 1] = Direction.LEFT.getDirection();
    }

    public Position nextPosition(Position position) {
        return row[position.get()].move(position);
    }

    private void validateNumberOfPerson(int numberOfPerson) {
        if(numberOfPerson < 1) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_PERSON_NUM.getMessage()); // 이렇게 사용하는 것이 맞나요??
        }
    }

    private void validateDrawLinePosition(int lineStartPosition) {
        if(lineStartPosition < 0 || lineStartPosition >= row.length - 1 || row[lineStartPosition].isLeft() || row[lineStartPosition + 1].isRight()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DRAW_LINE_POSITION.getMessage());
        }
    }
}
