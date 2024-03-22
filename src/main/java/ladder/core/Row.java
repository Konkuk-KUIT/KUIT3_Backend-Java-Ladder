package ladder.core;

import ladder.exception.ExceptionMessage;
import ladder.position.LadderPosition;
import ladder.position.Position;

public class Row {
    private Node[] nodes;

    public Row(NaturalNumber numberOfPerson) {
//        validateNumberOfPerson(numberOfPerson);
        nodes = new Node[numberOfPerson.getNum()];

        for (int i = 0; i < numberOfPerson.getNum(); i++){
            nodes[i] = Node.of(Direction.NONE);
        }

    }

    public void drawLine(Position lineStartPosition) {
        validateDrawLinePosition(lineStartPosition);
        nodes[lineStartPosition.getPosition()] = Node.of(Direction.RIGHT);
        nodes[lineStartPosition.getPosition() + 1] = Node.of(Direction.LEFT);
    }

    public Position nextPosition(Position currentPosition) {

//        validatePosition(position);
        isInvalidNextPosition(currentPosition);
        Position nextPosition = nodes[currentPosition.getPosition()].move(currentPosition);
        return nextPosition;

    }

        //기존에 작성했던 메서드
//    private void validateDrawLinePosition(Position lineStartPosition) {
//        if(lineStartPosition.getPosition() >= nodes.length - 1
//                || nodes[lineStartPosition.getPosition()] == Node.of(Direction.LEFT)
//                || nodes[lineStartPosition.getPosition() + 1] == Node.of(Direction.RIGHT)) {
//            throw new IllegalArgumentException(ExceptionMessage.INVALID_LADDER_DRAWLINE.getMessage());
//        }
//    }

//    private void validatePosition(Position position) {
//        if(position.getPosition() >= nodes.length || position.getPosition() < 0 ) {
//            throw new IllegalArgumentException(ExceptionMessage.INVALID_LADDER_POSITION.getMessage());
//        }
//    }

    //기존에 생각하지 못한 메서드들
    private void validateDrawLinePosition(Position startPosition) {
        if (isInvalidDrawPosition(startPosition) || isDuplicatedDrawPosition(startPosition)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LADDER_DRAWLINE.getMessage());
        }
    }

    private boolean isDuplicatedDrawPosition(Position position) {
        return (nodes[position.getPosition()].isRight()
                || nodes[position.next().getPosition()].isRight()
                || nodes[position.getPosition()].isLeft());
    }

    // 검증 메서드
    private boolean isInvalidDrawPosition(Position position) {
        if (position.isBiggerThan(nodes.length - 2) || position.isSmallerThan(0)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LADDER_DRAWLINE.getMessage());
        }
        return false;
    }

    private void isInvalidNextPosition(Position position) {
        if (position.isBiggerThan(nodes.length - 1) || position.isSmallerThan(0)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LADDER_POSITION.getMessage());
        }
    }

    public boolean isDrawable(Position position) {
        return !isInvalidDrawPosition(position) && !isDuplicatedDrawPosition(position);
    }

    public boolean isLineDrawn(int j) {
        return nodes[j].isRight();
    }

    private void validatePosition(Position position) {
        if (isInvalidPosition(position)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LADDER_POSITION.getMessage());
        }
    }

    private boolean isInvalidPosition(Position position) {
        return position.isBiggerThan(nodes.length - 1) || position.isSmallerThan(0);
    }


    public void generateRow(StringBuilder sb, Position drawingRow, LadderPosition currentPosition) {
        for(int i = 0; i < nodes.length; i++) {
            nodes[i].appendSymbol(sb);
            if(currentPosition.equals(LadderPosition.of(drawingRow, Position.of(i)))){
                sb.append("*");
            }
            sb.append(" ");
        }
        sb.append("\n");
    }
}
