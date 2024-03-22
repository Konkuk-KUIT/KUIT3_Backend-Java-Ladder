package ladder;

public class Row {
    // 필드로 Node[] 클래스만 갖는다. (조합 사용)
    private Node[] nodes;

    /**
     * 각 행의 nodes를 관리해보자.
     * 정적 팩터리 메서드 패턴을 통해 node 배열을 초기화하고,
     * 사람의 수를 NaturalNumber를 통해 인스턴스로 받아, Node 배열을 초기화 해보자.
     *
     * NaturalNumber 클래스를 통해 사람의 수를 예외처리하고,
     * 1개의 행의 nodes를 사람의 수로 초기화 한다.
     */

    public Row(NaturalNumber numberOfPerson) {
        nodes = new Node[numberOfPerson.getNum()];
        for (int i = 0; i < numberOfPerson.getNum(); i++) {
            nodes[i] = Node.of(Direction.NONE);
        }
    }

    // 사다리 그리기 (포지션을 입력받아 선 그리기)
    public void drawLine(Position startPosition) {
        validateDrawLinePosition(startPosition);
        setDirectionAtPosition(startPosition, Direction.RIGHT);
        setDirectionAtPosition(startPosition.next(), Direction.LEFT);
//        row[lineStartPosition] = 1;
//        row[lineStartPosition + 1] = -1;
    }

    private void setDirectionAtPosition(Position startPosition, Direction direction) {
        nodes[startPosition.getPosition()] = Node.of(direction);
    }

    /**
     * 선을 그리는 위치가 유효한지 판단.
     * 노드의 방향이 이미 정해진 경우를 판단하여 예외처리한다.
     */
    private void validateDrawLinePosition(Position  startPosition) {
        if (isInvalidDrawPosition(startPosition)
                || isDuplicatedDrawPosition(startPosition)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LINE_POSITION.getMessage());
    }
}

    private boolean isDuplicatedDrawPosition(Position position) {
        return (nodes[position.getPosition()].isRight()
            || nodes[position.next().getPosition()].isRight()
            || nodes[position.getPosition()].isLeft());
    }

    public Position nextPosition(Position currentPosition) {
        isInvalidNextPosition(currentPosition);
        return nodes[currentPosition.getPosition()].move(currentPosition);
//        if (isLeft(position)) {
//            return position - 1;
//        }
//        if (isRight(position)) {
//            return position + 1;
//        }
//
//        return position;
    }

    private boolean isInvalidDrawPosition(Position position) {
        if(position.isBiggerThan(nodes.length - 2) || position.isSmallerThan(0)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LINE_POSITION.getMessage());
        }
        return false;
    }

    private void isInvalidNextPosition(Position position) {
        if (position.isBiggerThan(nodes.length - 1) || position.isSmallerThan(0) ) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_POSITION.getMessage());
        }
    }
}
