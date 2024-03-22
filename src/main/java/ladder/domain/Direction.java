package ladder.domain;

public enum Direction{
    LEFT(-1),
    RIGHT(1),
    STAY(0);

    private final int direction;
    Direction(int direct){
        this.direction = direct;
    }

    public int getDirection(){
        return this.direction;
    }
}
