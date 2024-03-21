package ladder.model;

public class Node {
    private Direction direction;

    private Node(Direction direction) {
        this.direction = direction;
    }

    public static Node of(Direction direction) {
        return new Node(direction);
    }

    public Position move(Position position) {
        if (isRight()) {
            return position.next();
        }
        if (isLeft()) {
            return position.prev();
        }
        return position;
    }

    private boolean isRight() {
        return this.direction == Direction.RIGHT;
    }

    private boolean isLeft() {
        return this.direction == Direction.LEFT;
    }

    public Direction getDirection() {
        return this.direction;
    }
}