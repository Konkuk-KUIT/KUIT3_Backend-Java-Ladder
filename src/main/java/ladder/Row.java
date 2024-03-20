package ladder;

public class Row {
    private int[] row;
    private static final int RIGHT = 1;
    private static final int LEFT = -1;

    public Row(NaturalNumber numberOfPerson) {
        validateNumberOfPerson(numberOfPerson);
        row = new int[numberOfPerson.getNum()];
    }

    public void drawLine(Position lineStartPosition) {
        validateDrawLinePosition(lineStartPosition);
        row[lineStartPosition.getPosition()] = RIGHT;
        row[lineStartPosition.getPosition() + 1] = LEFT;
    }

    public Position nextPosition(Position position) {
        int newPosition = position.getPosition();
        validatePosition(newPosition);

        if (isLeft(newPosition)) {
            return position.prev();
        }
        if (isRight(newPosition)) {
            return position.next();
        }

        return position;
    }

    private boolean isLeft(int position) {
        return row[position] == LEFT;
    }

    private boolean isRight(int position) {
        return row[position] == RIGHT;
    }

    private void validateNumberOfPerson(NaturalNumber numberOfPerson) {
        if(numberOfPerson.getNum() < 1) {
            throw new IllegalArgumentException(String.valueOf(ExeptionMessage.INVALID_NUMBER_OF_PERSON));
        }
    }

    private void validateDrawLinePosition(Position lineStartPosition) {
        int pos = lineStartPosition.getPosition();
        if(pos < 0 || pos >= row.length - 1 || row[pos] == -1 || row[pos + 1] == 1) {
            throw new IllegalArgumentException(String.valueOf(ExeptionMessage.INVALID_LADDER_POSITION));
        }
    }

    private void validatePosition(int position) {
        if(position >= row.length || position < 0 ) {
            throw new IllegalArgumentException(String.valueOf(ExeptionMessage.INVALID_POSITION));
        }
    }
}