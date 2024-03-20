package ladder;

public class Row {
    private int[] row;

    public enum Direction {
        RIGHT(1),
        LEFT(-1),
        NONE(0);

        private final int directionValue;

        Direction(int directionValue) {
            this.directionValue = directionValue;
        }
    }

    public Row(NaturalNumber numberOfPerson) {
        validateNumberOfPerson(numberOfPerson);
        row = new int[numberOfPerson.get()];
    }

    public void drawLine(int lineStartPosition) {
        validateDrawLinePosition(lineStartPosition);
        row[lineStartPosition] = Direction.RIGHT.directionValue;
        row[lineStartPosition + 1] = Direction.LEFT.directionValue;
    }

    public int nextPosition(int position) {

        validatePosition(position);

        if (isLeft(position)) {
            return position + Direction.LEFT.directionValue;
        }
        if (isRight(position)) {
            return position + Direction.RIGHT.directionValue;
        }

        return position;
    }

    private boolean isLeft(int position) {
        return row[position] == Direction.LEFT.directionValue;
    }

    private boolean isRight(int position) {
        return row[position] == Direction.RIGHT.directionValue;
    }

    private void validateNumberOfPerson(NaturalNumber numberOfPerson) {
        if (numberOfPerson.get() < 1) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_OF_PERSON.getMessage());
        }
    }

    private void validateDrawLinePosition(int lineStartPosition) {
        if (lineStartPosition < 0 || lineStartPosition >= row.length - 1 || row[lineStartPosition] == Direction.LEFT.directionValue || row[lineStartPosition + 1] == Direction.RIGHT.directionValue) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DRAW_LINE_POSITION.getMessage());
        }
    }

    private void validatePosition(int position) {
        if (position >= row.length || position < 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LADDER_POSITION.getMessage());
        }
    }


}
