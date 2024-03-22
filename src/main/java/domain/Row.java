package domain;

import exception.ExceptionMessage;

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
        return nodes[currentPosition.getPosition()].move(currentPosition);

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

}
