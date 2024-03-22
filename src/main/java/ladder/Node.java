package ladder;

import Numbers.Position;

public class Node {
    final Direction Dir;

    private Node(Direction dir){
        Dir = dir;
    }

    public static Node SetNode(Direction Dir){
        return new Node(Dir);
    }

    public Direction NextPosition(){
        return Dir;
    }
    public int getDirNum(){return Dir.GetDirectionNum();}
    private boolean isright(){
        return Direction.RIGHT.equals(Dir);
    }

    private boolean isleft(){
        return Direction.LEFT.equals(Dir);
    }

    public boolean isnone(){
        return Direction.NONE.equals(Dir);
    }
    public Position Move(Position position){

        if (isleft()) {
            return position.prev();
        }
        if (isright()) {
            return position.next();
        }
        return position;
    }
}
