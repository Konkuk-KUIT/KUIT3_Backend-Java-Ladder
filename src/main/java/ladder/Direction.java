package ladder;

public enum Direction {
    NONE(0),
    RIGHT(1),
    LEFT(-1);

    private final int value;

    Direction(int value) {
        this.value = value;
    }

}
