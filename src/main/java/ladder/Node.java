package ladder;

public class Node {
    private final Direction direction;

    private Node(Direction direction){
        this.direction = direction;
    }

    public static Node of(Direction direction){
        return new Node(direction);
    }

    public Position move(Position position){
        if(direction == Direction.RIGHT){return position.next();}
        if(direction == Direction.LEFT){return position.prev();}
        return position;
    }

}
