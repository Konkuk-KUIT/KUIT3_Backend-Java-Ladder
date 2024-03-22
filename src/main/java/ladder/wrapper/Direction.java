package ladder.wrapper;

public enum Direction {
    LEFT(-1),
    CENTER(0),
    RIGHT(1);

    private final int directionValue;

    public int getDirectionValue() {
        return directionValue;
    }

    Direction(int directionValue) {
        this.directionValue = directionValue;
    }
}
