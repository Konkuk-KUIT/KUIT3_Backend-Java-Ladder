package ladder.core;

import ladder.position.Position;

public class Node {
    private Direction direction;

    private Node(Direction direction){
        this.direction = direction;
    }

    public Direction getDirection(){
        return direction;
    }

    public static Node of(Direction direction){
        return new Node(direction);
    }

    public Position move(Position position){
        if(isRight()){
            return position.next();
        }
        if(isLeft()){
            return position.prev();
        }
        return position;
    }

    public boolean isLeft() {
        return direction == Direction.LEFT;
    }

    public boolean isRight() {
        return direction == Direction.RIGHT;
    }

    public void appendSymbol(StringBuilder sb) {
        sb.append(this.direction.getValue());
    }
}
