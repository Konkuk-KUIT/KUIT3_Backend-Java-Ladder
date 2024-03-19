package ladder;

public class Position {
    private int position;

    private Position(int position) {
        this.position = position;
    }

    public static Position of(int position) {
        validatePosition(position);
        return new Position(position);
    }

    private static void validatePosition(int position) {
        if (position < 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_POSITION.getMessage());
        }
    }

    public Position prev() {
        return of(this.position - 1);
    }

    public Position next() {
        return of(this.position + 1);
    }

    public int getPosition() {
        return this.position;
    }

}