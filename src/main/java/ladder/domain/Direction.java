package ladder.domain;

public enum Direction {
    RIGHT(1),
    LEFT(-1),
    NONE(0);

    private final int value;

    Direction(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
