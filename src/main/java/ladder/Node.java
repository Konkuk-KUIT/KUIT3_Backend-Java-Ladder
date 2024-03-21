package ladder;

public class Node {
    private Direction dir;

    private Node(Direction dir) {
        this.dir = dir;
    }

    public static Node of(Direction dir) {
        return new Node(dir);
    }

    public Direction get() {
        return dir;
    }

    public void setGoLeft() {
        dir = Direction.LEFT;
    }

    public void setGoRight() {
        dir = Direction.RIGHT;
    }

    public boolean isLeft() {
        return dir == Direction.LEFT;
    }

    public boolean isRight() {
        return dir == Direction.RIGHT;
    }
}
