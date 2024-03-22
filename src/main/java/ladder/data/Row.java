package ladder.data;

import type.Direction;
import type.NaturalNumber;
import type.Node;
import type.Position;

public class Row {

    private final int MIN_NUMBER_OF_PERSON = 1;
    private Node[] row;

    public Row(NaturalNumber numberOfPerson) {
        validateNumberOfPerson(numberOfPerson.getValue());
        row = new Node[numberOfPerson.getValue()];
        for(Position i = new Position(0); i.getPosition() < row.length; i.increase()) {
            row[i.getPosition()] = new Node(Direction.NO_DIRECTION);
        }
    }

    public void drawLine(Position lineStartPosition) {
        validateDrawLinePosition(lineStartPosition.getPosition());
        row[lineStartPosition.getPosition()].setRight();
        row[lineStartPosition.movePosition(Direction.RIGHT.get())].setLeft();
    }

    public Position nextPosition(Position position) {
        validatePosition(position.getPosition());

        if (isLeft(position)) {
            position.movePosition(Direction.LEFT.get());
        } else if (isRight(position)) {
            position.movePosition(Direction.RIGHT.get());
        }

        return position;
    }

    private boolean isLeft(Position position) {
        return row[position.getPosition()].isLeft();
    }

    private boolean isRight(Position position) {
        return row[position.getPosition()].isRight();
    }

    private void validateNumberOfPerson(int numberOfPerson) {
        if(numberOfPerson < MIN_NUMBER_OF_PERSON) {
            throw new IllegalArgumentException("게임의 참여자 수는 1명 이상이어야 합니다.");
        }
    }

    private void validateDrawLinePosition(int lineStartPosition) {
        if(lineStartPosition < Position.MIN_POSITION ||
                lineStartPosition >= row.length - 1 ||
                row[lineStartPosition].isLeft() ||
                row[lineStartPosition + 1].isRight() ||
                row[lineStartPosition].isRight() ||
                row[lineStartPosition + 1].isLeft()) {
            throw new IllegalArgumentException("라인 생성이 불가능한 위치 입니다.");
        }
    }

    private void validatePosition(int position) {
        if(position >= row.length || position < Position.MIN_POSITION ) {
            throw new IllegalArgumentException("유효하지 않은 위치 입니다.");
        }
    }

    public void print(Position position) {
        int i = 0;
        for(Node node : row) {
            if(node.isRight()) System.out.print(Direction.RIGHT.get());
            else if(node.isLeft()) System.out.print(Direction.LEFT.get());
            else System.out.print(Direction.NO_DIRECTION.get());

            if(position != null && position.getPosition() == i) System.out.print("*");
            System.out.print(" ");
            i++;
        }
    }

}
