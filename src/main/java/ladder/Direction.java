package ladder;

public enum Direction {
    RIGHT(1),
    LEFT(-1),
    NONE(0);

    private final int directionValue;

    Direction(int directionValue) {
        this.directionValue = directionValue;
    }
    public int getDirectionValue(){
        return directionValue;
    }
}