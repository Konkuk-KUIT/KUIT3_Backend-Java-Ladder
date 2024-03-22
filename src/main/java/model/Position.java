package model;

public class Position {
    private int position;

    public Position(int position){
        this.position = position;
    }
    public static Position of(int position){
        Position p = new Position(position);
        return p;
    }
    public int getPosition(){
        return position;
    }
    public Position move_right(){
        return new Position(position+1);
    }
    public Position move_left(){
        return new Position(position-1);
    }

}
