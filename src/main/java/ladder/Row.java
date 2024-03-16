package ladder;

public class Row {
    private Node[] nodes;

    public Row(int numberOfPerson) {
        nodes = new Node[numberOfPerson];
        for (int i = 0; i < numberOfPerson; i++) {
            nodes[i] = new Node(LadderDirection.STAY);
        }
    }

    public void drawLine(Position lineStartPosition) {
        validateDrawLinePosition(lineStartPosition);
        nodes[lineStartPosition.getPosition()] = new Node(LadderDirection.RIGHT);
        nodes[lineStartPosition.increment().getPosition()] = new Node(LadderDirection.LEFT);
    }

    public Position nextPosition(Position currentPosition) {
        validatePosition(currentPosition);
        return nodes[currentPosition.getPosition()].next(currentPosition);
    }



    private void validateDrawLinePosition(Position lineStartPosition) {
        if(lineStartPosition.getPosition() < 0
                || lineStartPosition.getPosition() >= nodes.length - 1
                || nodes[lineStartPosition.getPosition()].isLeft()
                || nodes[lineStartPosition.increment().getPosition()].isRight()) {
            throw new IllegalArgumentException("라인 생성이 불가능한 위치 입니다.");
        }
    }

    private void validatePosition(Position position) {
        if(position.getPosition() >= nodes.length || position.getPosition() < 0 ) {
            throw new IllegalArgumentException("유효하지 않은 위치 입니다.");
        }
    }




}
