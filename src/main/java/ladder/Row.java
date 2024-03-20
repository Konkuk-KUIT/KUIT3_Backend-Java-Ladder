package ladder;

public class Row {
    private Node[] row;



    public Row(NaturalNumber numberOfPerson) {
        validateNumberOfPerson(numberOfPerson);
        row = new Node[numberOfPerson.get()];
    }

    public void drawLine(Position lineStartPosition) {
        validateDrawLinePosition(lineStartPosition.getPosition());
        row[lineStartPosition.getPosition()] = Node.of(Direction.LEFT);
        row[lineStartPosition.getPosition() + 1] = Node.of(Direction.RIGHT);
    }



    private void validateNumberOfPerson(NaturalNumber numberOfPerson) {
        if (numberOfPerson.get() < 1) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_OF_PERSON.getMessage());
        }
    }

    private void validateDrawLinePosition(int lineStartPosition) {
        if (lineStartPosition < 0 || lineStartPosition >= row.length - 1 || row[lineStartPosition] == Direction.LEFT || row[lineStartPosition + 1] == Direction.RIGHT.getDirectionValue()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DRAW_LINE_POSITION.getMessage());
        }
    }

    private void validatePosition(int position) {
        if (position >= row.length || position < 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LADDER_POSITION.getMessage());
        }
    }


}
