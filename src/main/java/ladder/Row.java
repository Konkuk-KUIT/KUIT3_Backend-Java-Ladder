package ladder;

public class Row {
    private Node[] row;

    public Row(int numberOfPerson) {
        validateNumberOfPerson(numberOfPerson);
        row = new Node[numberOfPerson];
        //모든 위치 초기 방향 NONE으로 설정
        for (int i = 0; i < row.length; i++) {
            row[i] = Node.of(Direction.NONE);
        }
    }

    public void drawLine(int lineStartPosition) {
        validateDrawLinePosition(lineStartPosition);
        row[lineStartPosition] = Node.of(Direction.RIGHT);
        row[lineStartPosition + 1] = Node.of(Direction.LEFT);
    }

    public int nextPosition(int position) {
        validatePosition(position);

        Position currentPosition = Position.of(position);
        Position nextPosition = row[position].move(currentPosition);

        return nextPosition.getPosition();
    }

    public String toString(LadderPosition starPosition,int y) {
        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < row.length; x++) {
            if (starPosition.isEqualPosition(x, y)) {
                sb.append(row[x].getDirection().getValue()).append("* ");
            } else {
                sb.append(row[x].getDirection().getValue()).append("  ");
            }
        }
        return sb.toString().trim();
    }

//    private boolean isLeft(int position) {
//        return row[position] == Direction.LEFT.getValue();
//    }
//
//    private boolean isRight(int position) {
//        return row[position] == Direction.RIGHT.getValue();
//    }

    private void validateNumberOfPerson(int numberOfPerson) {
        if(numberOfPerson < 1) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_OF_PERSON.getMessage());
        }
    }


    private void validateDrawLinePosition(int lineStartPosition) {
        if(lineStartPosition < 0 || lineStartPosition >= row.length - 1) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LINE_CREATE_POSITION.getMessage());
        }
        // Node 상태를 직접 확인하여 이전 노드나 다음 노드가 이미 연결되어 있는지 확인
        if(row[lineStartPosition].getDirection() == Direction.LEFT || row[lineStartPosition + 1].getDirection() == Direction.RIGHT
        || row[lineStartPosition].getDirection() == Direction.RIGHT || row[lineStartPosition + 1].getDirection() == Direction.LEFT) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LINE_CREATE_POSITION.getMessage());
        }
    }

    private void validatePosition(int position) {
        if(position >= row.length || position < 0 ) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_POSITION.getMessage());
        }
    }
}
