package ladder;

// Direction 조합해 사다리 안의 요소로 사용
// 이후에 Direction 외에 다른 속성 추가되어도 Row, Ladder 까지 다 바꿀 필요x
// Node 랑 Node 생성하는 곳만 수정하면 됨
// ex) 대각선 허용될 경우 rowNumDiff
public final class Node {

    //final
    final private Direction direction;

    private Node(Direction direction) {
        this.direction = direction;
    }

    // static factory method
    // 어떤 방향으로 뻗어가는 Node 인지, 기울기 0으로 평행함을 명시
    // 대각선 추가될 경우 두 생성자에 이름 붙여 구분 가능
    static public Node parallelTo(Direction direction) {
        return new Node(direction);
    }

    public boolean hasDirection() {
        return !direction.equals(Direction.NONE);
    }

    // Node 에 대각선 추가 등 변경이 있어도 밖에서 play 하는 데는 지장 없도록
    // position 을 넣으면 position 이 나옴
    public int getNextPosition(int currentPosition) {
        return currentPosition + direction.getColDiff();
    }
}