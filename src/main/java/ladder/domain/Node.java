package ladder.domain;

import ladder.domain.Direction;

public class Node {
    private final Direction nodeDirection;

    private Node(Direction nodeDirection){
        this.nodeDirection = nodeDirection;
    }

    public Position move(Position position) {
        if(isRight()) {
            return position.nextPosition();
        }
        if(isLeft()){
            return position.prevPosition();
        }
        return position;
    }

    public boolean isRight() {
        return nodeDirection == Direction.RIGHT;
    }

    public boolean isLeft() {
        return nodeDirection == Direction.LEFT;
    }

    // 정적 팩토리 메소드
    public static Node of(Direction direction) {
        return new Node(direction);
    }
}
