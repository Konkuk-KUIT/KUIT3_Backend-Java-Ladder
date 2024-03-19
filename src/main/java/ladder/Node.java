package ladder;

import java.util.Objects;

public class Node {
    private final Direction direction;

    private Node(Direction direction) {
        this.direction = direction;
    }

    public static Node from(Direction direction) {
        return new Node(direction);
    }

    public Position move(Position position) {
        if(isLeft()) {
            return position.prev();
        }

        if(isRight()) {
            return position.next();
        }

        return position;
    }

    private boolean isLeft() {
        return this.direction == Direction.LEFT;
    }

    private boolean isRight() {
        return this.direction == Direction.RIGHT;
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Node node = (Node) obj;
        return Objects.equals(this.direction, node.direction);
    }
}
