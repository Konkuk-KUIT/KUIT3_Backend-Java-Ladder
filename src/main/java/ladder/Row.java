package ladder;

public class Row {
    private Node[] nodes;

    public Row(int numberOfPerson) {
        validateNumberOfPerson(numberOfPerson);
        nodes = new Node[numberOfPerson];
        for(int i = 0; i < numberOfPerson; i++) {
            nodes[i] = Node.of(Direction.NONE);
        }
    }

    public void drawLine(Position lineStartPosition) {
        validateDrawLinePosition(lineStartPosition);

        setDirectionAtPosition(lineStartPosition, Direction.RIGHT);
        setDirectionAtPosition(lineStartPosition.next(), Direction.LEFT);
    }

    public Position nextPosition(Position currentPosition) {
        validatePosition(currentPosition);
        return nodes[currentPosition.getValue()].move(currentPosition);
    }

    private void setDirectionAtPosition(Position position, Direction direction) {
        nodes[position.getValue()] = Node.of(direction);
    }

    private void validateNumberOfPerson(int numberOfPerson) {
        if(numberOfPerson < 1) {
            throw new IllegalArgumentException("게임의 참여자 수는 1명 이상이어야 합니다.");
        }
    }

    private void validateDrawLinePosition(Position lineStartPosition) {
        if(isInvalidDrawPosition(lineStartPosition)
                || nodes[lineStartPosition.getValue()].isRight()
                || nodes[lineStartPosition.next().getValue()].isRight()
                || nodes[lineStartPosition.getValue()].isLeft()) {
            throw new IllegalArgumentException("라인 생성이 불가능한 위치 입니다.");
        }
    }

    private void validatePosition(Position position) {
        if(position.isBiggerThan(nodes.length - 1) || position.isSmallerThan(0) ) {
            throw new IllegalArgumentException("유효하지 않은 위치 입니다.");
        }
    }

    private boolean isInvalidDrawPosition(Position lineStartPosition) {
        return lineStartPosition.isBiggerThan(nodes.length - 2) || lineStartPosition.isSmallerThan(0);
    }




}
