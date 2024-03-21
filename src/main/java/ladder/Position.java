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

    public int getValue() {
        return position;
    }

    public Position prev() {
        return Position.of(position - 1);
    }

    public Position next() {
        return Position.of(position + 1);
    }

    // 유효성 검증
    private static void validatePosition(int position) {
        if (!isPosition(position)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_POSITION.getMessage());
        }
    }

    private static boolean isPosition(int position) {
        return position >= 0;
    }
}
