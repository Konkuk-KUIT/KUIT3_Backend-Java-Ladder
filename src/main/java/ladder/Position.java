package ladder;


import ladder.ExceptionMessage;

public class Position {
    private int position;
    private Position(int position) {
        this.position = position;
    }
    public static Position of(int position) {
        validatePosition(position);
        return new Position(position);
    }

    public Position prev() {
        return of(position - 1);
    }

    public Position next() {
        return of(position + 1);
    }

    public boolean isSmallerThan(int position) {
        return this.position < position;
    }

    public boolean isBiggerThan(int position) {
        return this.position > position;
    }

    public int getValue() {
        return position;
    }

    private static void validatePosition(int position) {
        if(!isPosition(position)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_POSITION.getMessage());
        }
    }

    private static boolean isPosition(int position) {
        return position >= 0;
    }

}