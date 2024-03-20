package ladder;

public class Row {
    private int[] row;



    public Row(NaturalNumber numberOfPerson) {
        validateNumberOfPerson(numberOfPerson);
        row = new int[numberOfPerson.get()];
    }

    public void drawLine(int lineStartPosition) {
        validateDrawLinePosition(lineStartPosition);
        row[lineStartPosition] = Direction.RIGHT.getDirectionValue();
        row[lineStartPosition + 1] = Direction.LEFT.getDirectionValue();
    }

    public int nextPosition(int position) {

        validatePosition(position);

        if (isLeft(position)) {
            return position + Direction.LEFT.getDirectionValue();
        }
        if (isRight(position)) {
            return position + Direction.RIGHT.getDirectionValue();
        }

        return position;
    }

    private boolean isLeft(int position) {
        return row[position] == Direction.LEFT.getDirectionValue();
    }

    private boolean isRight(int position) {
        return row[position] == Direction.RIGHT.getDirectionValue();
    }

    private void validateNumberOfPerson(NaturalNumber numberOfPerson) {
        if (numberOfPerson.get() < 1) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_OF_PERSON.getMessage());
        }
    }

    private void validateDrawLinePosition(int lineStartPosition) {
        if (lineStartPosition < 0 || lineStartPosition >= row.length - 1 || row[lineStartPosition] == Direction.LEFT.getDirectionValue() || row[lineStartPosition + 1] == Direction.RIGHT.getDirectionValue()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DRAW_LINE_POSITION.getMessage());
        }
    }

    private void validatePosition(int position) {
        if (position >= row.length || position < 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LADDER_POSITION.getMessage());
        }
    }


}
