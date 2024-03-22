package ladder;

/**
 *  각 행은 Node를 통해서 관리한다.
 *  상속 대신 조합을 통해 클래스를 관리해보자.
 */

public class Node {
    // 필드로 Direction 클래스만 갖는다. (조합 사용)
    private Direction direction;

    // 생성자는 private이며, direction 인스턴스를 받아 필드를 초기화한다.
    private Node(Direction direction) {
        this.direction = direction;
    }

    // 정적 팩터리 메서드 패턴
    public static Node of(Direction direction) {
        return new Node(direction);
    }

    // node의 move 메서드를 통해, 현재 위치를 입력받아, 현재 위치의 다음 위치를 반환한다.
    public Position move(Position position) {
        if (isRight()) {
            return position.next();
        }
        if (isLeft()) {
            return position.prev();
        }
        return position;
    }

    // 각 노드(사다리가 오른쪽을 가지는지) 방향 확인
    public boolean isRight() {
        return direction == Direction.RIGHT;
    }

    public boolean isLeft() {
        return direction == Direction.LEFT;
    }

}
