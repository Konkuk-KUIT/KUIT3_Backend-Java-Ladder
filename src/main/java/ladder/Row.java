package ladder;

import ladder.exception.ExceptionMessage;

import static ladder.exception.ExceptionMessage.*;

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

    public boolean hasLine(Position position) {
        validatePosition(position);
        return nodes[position.getPosition()].isRight() || nodes[position.getPosition()].isLeft();
    }

    private void validateDrawLinePosition(Position lineStartPosition) {
        if(lineStartPosition.getPosition() < 0
                || lineStartPosition.getPosition() >= nodes.length - 1
                || nodes[lineStartPosition.getPosition()].isRight()
                || nodes[lineStartPosition.increment().getPosition()].isRight()
                || nodes[lineStartPosition.getPosition()].isLeft()) {
            throw new IllegalArgumentException(DUPLICATE_LINE.getMessage());
        }
    }

    private void validatePosition(Position position) {
        if(position.getPosition() >= nodes.length || position.getPosition() < 0 ) {
            throw new IllegalArgumentException(INVALID_POSITION.getMessage());
        }
    }


    public void printRow(StringBuilder sb,Position Row ,LadderPosition currentPosition){
        for (int i = 0; i < nodes.length; i++) {
            sb.append(nodes[i].getLadderDirection());
            if (currentPosition.equals(LadderPosition.fromCoordinate(Row, Position.fromValue(i)))) {
                sb.append("*");
            }
            sb.append(" ");
        }
        sb.append("\n");
    }

    public int getSize(){
        return nodes.length;
    }

}
