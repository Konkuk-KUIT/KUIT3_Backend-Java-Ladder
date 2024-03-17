package ladder;

public class Row {
    private int[] row;

    public Row(int numberOfPerson) {
        validateNumberOfPerson(numberOfPerson);
        row = new int[numberOfPerson];
    }

    public void drawLine(Position lineStartPosition) {
        validateDrawLinePosition(lineStartPosition);

        setDirectionAtPosition(lineStartPosition, Direction.RIGHT);
        setDirectionAtPosition(lineStartPosition.next(), Direction.LEFT);
    }

    public Position nextPosition(Position currentPosition) {

        validatePosition(currentPosition);

        if (isLeft(currentPosition)) {
            return currentPosition.prev();
        }
        if (isRight(currentPosition)) {
            return currentPosition.next();
        }

        return currentPosition;
    }

    private void setDirectionAtPosition(Position position, Direction direction) {
        row[position.getValue()] = direction.getValue();
    }

    private boolean isLeft(Position position) {
        return row[position.getValue()] == Direction.LEFT.getValue();
    }

    private boolean isRight(Position position) {
        return row[position.getValue()] == Direction.RIGHT.getValue();
    }

    private void validateNumberOfPerson(int numberOfPerson) {
        if(numberOfPerson < 1) {
            throw new IllegalArgumentException("게임의 참여자 수는 1명 이상이어야 합니다.");
        }
    }

    private void validateDrawLinePosition(Position lineStartPosition) {
        if(isInvalidDrawPosition(lineStartPosition)
                || isRight(lineStartPosition)
                || isRight(lineStartPosition.next())
                || isLeft(lineStartPosition)) {
            throw new IllegalArgumentException("라인 생성이 불가능한 위치 입니다.");
        }
    }

    private void validatePosition(Position position) {
        if(position.isBiggerThan(row.length - 1) || position.isSmallerThan(0) ) {
            throw new IllegalArgumentException("유효하지 않은 위치 입니다.");
        }
    }

    private boolean isInvalidDrawPosition(Position lineStartPosition) {
        return lineStartPosition.isBiggerThan(row.length - 1) || lineStartPosition.isSmallerThan(0);
    }




}
