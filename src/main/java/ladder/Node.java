package ladder;

public class Node {
    private Direction direction;

    private Node(Direction direction){
        this.direction = direction;

    }

    public static Node of(Direction direction){
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

    protected boolean isLeft() {
        return this.direction == Direction.LEFT;
    }

    protected boolean isRight() {
        return this.direction == Direction.RIGHT;
    }

    public void drawLeft() {
        direction = Direction.LEFT;
    }
    public void drawRight() {
        direction = Direction.RIGHT;
    }


    // 게임 실행 중 결과 출력을 위해, 값 가져오기
    public int getValue() {
        return direction.getDirection();

    }
}
