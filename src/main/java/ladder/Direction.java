package ladder;

public enum Direction {
    RIGHT(1),
    LEFT(-1),
    NONE(0);
    private final int direction;
    Direction(int direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return String.valueOf(direction);
    }

    public boolean isLeft() {
        return this.equals(Direction.LEFT);
    }

    public boolean isRight() {
        return this.equals(Direction.RIGHT);
    }
}
