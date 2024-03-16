package ladder;

public class Node {
    private LadderDirection ladderDirection;

    public Node(LadderDirection ladderDirection) {
        this.ladderDirection = ladderDirection;
    }

    public Position next(Position position) {
        if (isLeft()) {
            return position.decrement();
        }
        if (isRight()) {
            return position.increment();
        }

        return position;
    }

    public boolean isLeft() {
        return ladderDirection == LadderDirection.LEFT;
    }

    public boolean isRight() {
        return ladderDirection == LadderDirection.RIGHT;
    }



}
