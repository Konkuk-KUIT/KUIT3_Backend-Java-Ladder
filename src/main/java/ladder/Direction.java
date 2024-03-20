package ladder;

public enum Direction {
    RIGHT(1),
    LEFT(-1),
    NONE(0);

    private final int move;

    Direction(int move) {
        this.move= move;
    }

    public int getMove(){
        return move;
    }
}
