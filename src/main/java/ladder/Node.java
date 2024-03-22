package ladder;

public class Node {

    private Direction direction;

    private Node(Direction direction){
        this.direction = direction;
    }

    public static Node of(Direction direction){
        return new Node(direction);
    }

    public Position move(Position position){
        if(isRight()){
            return position.next();
        }
        else if(isLeft()){
            return position.prev();
        }
        return position;
    }

    public boolean isRight(){
        return direction == Direction.RIGHT;
    }
    public boolean isLeft(){
        return direction == Direction.LEFT;
    }


}
