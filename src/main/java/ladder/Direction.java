package ladder;

public enum Direction {
    LEFT(-1),
    CENTER(0),
    RIGHT(1);

    private final int directionValue;

    Direction(int directionValue) {
        this.directionValue = directionValue;
    }
}
