package ladder.wrapper;

import ladder.util.ExceptionMessage;

public class Position {
    private int position;
    private NaturalNumber numberOfPossiblePosition; // 웬만하면 numberOfPerson 이지만, 사다리의 행도 관리하므로

    private Position(int position, NaturalNumber numberOfPossiblePosition) {
        validatePosition(position, numberOfPossiblePosition);
        this.position = position;
        this.numberOfPossiblePosition = numberOfPossiblePosition;
    }

    private void validatePosition(int position, NaturalNumber numberOfPossiblePosition) {
        if (position < 0 || position >= numberOfPossiblePosition.get()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_POSITION.get());
        }
    }

    public static Position of(int position, NaturalNumber numberOfPossiblePosition) {
        return new Position(position, numberOfPossiblePosition);
    }

    public int get() {
        return position;
    }

    public Position prev() {
        return new Position(position - 1, numberOfPossiblePosition);
    }

    public Position next() {
        return new Position(position + 1, numberOfPossiblePosition);
    }
}
