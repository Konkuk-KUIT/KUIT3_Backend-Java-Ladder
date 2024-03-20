package ladder.model;

public enum LadderDirection {
    RIGHT(1),
    LEFT(-1),
    STAY(0);

    private final int value;

    LadderDirection(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
