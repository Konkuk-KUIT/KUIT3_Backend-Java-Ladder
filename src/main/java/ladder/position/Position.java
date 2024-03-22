package ladder.position;

import ladder.exception.ExceptionMessage;

public class Position {
    private final int position;

    private Position(int position) {
        this.position = position;
    }

    public static Position of(int position) {
        validatePosition(position);
        return new Position(position);
    }

    public Position prev() {
        return new Position(position - 1);
    }

    public Position next() {
        return new Position(position + 1);
    }


    private static void validatePosition(int position) {
        if (position < 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LADDER_POSITION.getMessage());
        }
    }


    public int getPosition() {
        return position;
    }

    public boolean isSmallerThan(int position) {
        return this.position <= position;
    }

    public boolean isBiggerThan(int position) {
        return this.position >= position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;

        Position other = (Position) o;
        return position == other.position;
    }
}
