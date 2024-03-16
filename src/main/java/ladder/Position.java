package ladder;

public class Position {
    private int position;

    public Position(int position){
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public Position increment(){
        return new Position(position+1);
    }

    public Position decrement(){
        return new Position(position-1);
    }
}
