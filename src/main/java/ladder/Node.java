package ladder;

public class Node {
    private Direction dir;

    private Node(Direction dir) {
        this.dir = dir;
    }

    public static Node of(Direction dir) {
        return new Node(dir);
    }

    public Direction value() {
        return dir;
    }

    public void setGoLeft() {
        dir = Direction.LEFT;
    }

    public void setGoRight() {
        dir = Direction.RIGHT;
    }
}
