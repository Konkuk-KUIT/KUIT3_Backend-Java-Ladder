package ladder;
import static ladder.ExceptionMessage.*;
public class Row {

    private final Node[] nodes;

    public Row(NaturalNumber numberOfPerson) {

        nodes = new Node[numberOfPerson.get()];
        for (int i = 0; i < numberOfPerson.get(); i++) {
            nodes[i] = Node.of(Direction.NONE);
        }

    }

    public void drawLine(Position lineStartPosition) {

        validateDrawLinePosition(lineStartPosition);
        nodes[lineStartPosition.getValue()] = Node.of(Direction.RIGHT);
        nodes[lineStartPosition.next().getValue()] = Node.of(Direction.LEFT);
    }

    public Position nextPosition(Position position) {

        isInvalidNextPosition(position);
        return nodes[position.getValue()].move(position);
    }

    public String[] getRowToString() {
        String[] stringArray = new String[nodes.length];
        for (int i = 0; i < stringArray.length; i++) {
            stringArray[i] = String.valueOf(nodes[i].getDirectionValue());
        }
        return stringArray;
    }

    private void validateDrawLinePosition(Position startPosition) {
        if (isInvalidDrawPosition(startPosition) || isDuplicatedDrawPosition(startPosition)) {
            throw new IllegalArgumentException(INVALID_DRAW_POSITION.getMessage());
        }
    }

    private boolean isDuplicatedDrawPosition(Position position) {
        return (nodes[position.getValue()].isRight()
                || nodes[position.next().getValue()].isRight()
                || nodes[position.getValue()].isLeft());
    }

    // 검증 메서드
    private boolean isInvalidDrawPosition(Position position) {
        if (position.isBiggerThan(nodes.length - 2) || position.isSmallerThan(0)) {
            throw new IllegalArgumentException(INVALID_DRAW_POSITION.getMessage());
        }
        return false;
    }

    private void isInvalidNextPosition(Position position) {
        if (position.isBiggerThan(nodes.length - 1) || position.isSmallerThan(0)) {
            throw new IllegalArgumentException(INVALID_POSITION.getMessage());
        }
    }

}

