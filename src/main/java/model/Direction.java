package model;

public enum Direction {
    RIGHT(1),
    LEFT(-1),
    CENTER(0);

    private final int direct;
    Direction(int direct) {
        this.direct = direct;
    }
    public int getDirect(){
        return direct;
    }
}
