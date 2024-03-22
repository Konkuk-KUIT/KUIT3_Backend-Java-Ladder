package ladder;

public enum Direction {
    LEFT(-1),NONE(0),RIGHT(1);
    private int dir;
    Direction(int dir){
        this.dir=dir;
    }

    public int GetDirectionNum(){
        return dir;
    }
}
