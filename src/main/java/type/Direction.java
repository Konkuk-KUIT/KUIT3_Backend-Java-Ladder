package type;

public enum Direction {

    RIGHT(1),
    LEFT(-1),
    NO_DIRECTION(0);

    private final int direction;

    Direction(int direction) {
        this.direction = direction;
    }

    public int get() {
        return direction;
    }

}