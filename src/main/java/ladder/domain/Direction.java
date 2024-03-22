package ladder.domain;

public enum Direction {
    RIGHT_MOVE(1),
    LEFT_MOVE(-1),
    NO_MOVE(0);

    private final int value;

    Direction(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
