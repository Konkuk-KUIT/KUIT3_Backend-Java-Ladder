package type;

public class Node {

    private Direction direction;

    public Node(Direction direction) {
        this.direction = direction;
    }

    public boolean isRight() {
        return direction.compareTo(Direction.RIGHT) == 0;
    }

    public boolean isLeft() {
        return direction.compareTo(Direction.LEFT) == 0;
    }

    public void setRight() {
        direction = Direction.RIGHT;
    }

    public void setLeft() {
        direction = Direction.LEFT;
    }

}
