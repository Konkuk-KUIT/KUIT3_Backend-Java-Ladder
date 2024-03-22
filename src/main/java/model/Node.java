package model;

public class Node {
    private Direction direction;

    public Node(Direction direction){
        this.direction = direction;
    }
    public static Node of(Direction direction){
        Node n = new Node(direction);
        return n;
    }
    
    public Direction getDirection(){
        return direction;
    }

    public Position move(Position position) {
        if(isLeft()){
            return position.move_left();
        }
        if(isRight()){
            return position.move_right();
        }
        return position;
    }
    private boolean isLeft() {
        return direction == Direction.LEFT;
    }

    private boolean isRight() {
        return direction == Direction.RIGHT;
    }
}
