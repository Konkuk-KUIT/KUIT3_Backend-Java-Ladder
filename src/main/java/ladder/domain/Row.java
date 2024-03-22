package ladder.domain;

import ladder.exception.ExceptionMessage;

public class Row {
    private Node[] nodes;

    public Row(NaturalNumber numberOfPerson) {
        nodes = new Node[numberOfPerson.get()];
        // 사다리 결과 확인 태스트 에러 원인
        for(int i = 0; i < nodes.length; i++){
            nodes[i] = new Node(Direction.NONE);
        }
    }

    public void drawLine(Position lineStartPosition) {
        validateDrawLinePosition(lineStartPosition);
        nodes[lineStartPosition.get()].set(Direction.RIGHT);
        nodes[lineStartPosition.next().get()].set(Direction.LEFT);
    }

    public Position nextPosition(Position position) {
        validatePosition(position);
        return nodes[position.get()].move(position);
    }

    private void validateDrawLinePosition(Position lineStartPosition) {
        if(lineStartPosition.isBiggerThan(nodes.length - 2) || nodes[lineStartPosition.get()].isLeft() || nodes[lineStartPosition.next().get()].isRight()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DRAW_LINE_POSITION.getMessage());
        }
    }

    void validatePosition(Position position){
        if(position.isBiggerThan(nodes.length -1)){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_POSITION.getMessage());
        }
    }

    public StringBuilder convertRowToString(Position currentPosition, boolean isStarOnThisRow){
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < nodes.length; i++){
            result.append(nodes[i].get());
            if(isStarOnThisRow && currentPosition.get() == i){
                result.append("*");
            }
            result.append(" ");
        }
        result.append("\n");
        return result;
    }
}
