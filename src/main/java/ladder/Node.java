package ladder;

public class Node {
    private Direction direction;
    private Node(Direction direction){
        this.direction = direction;
    }
    public static Node of(Direction direction){
        return new Node(direction);
    }
    //notion에서 copy
    public Position move(Position position) {
        if (isRight()) {
            return position.next();
        }
        if (isLeft()) {
            return position.prev();
        }
        return position;
    }

    public boolean isRight() {
        if(direction == Direction.RIGHT)
            return true;
        return false;
    }
    public boolean isLeft() {
        if(direction == Direction.LEFT)
            return true;
        return false;
    }

}
