package ladder;

import java.util.Objects;

public class Row {
//    private Direction[] row;
    private final Node[] nodes;

    public Row(NaturalNumber numberOfPerson) {
        nodes = new Node[numberOfPerson.get()];     // TODO: node들의 배열에서 각 노드들 초기화 해줘야 하는가?
        for(int i = 0; i < numberOfPerson.get(); i++) {
            nodes[i] = Node.from(Direction.CENTER);
        }
    }

    public void drawLine(Position lineStartPosition) {   // 오른쪽 찍 한줄 긋기
        validateDrawLinePosition(lineStartPosition);
        nodes[lineStartPosition.get()] = Node.from(Direction.RIGHT);
        nodes[lineStartPosition.next().get()] = Node.from(Direction.LEFT);
    }

    public Position slide(Position position) {
        return nodes[position.get()].move(position);
    }

    private void validateDrawLinePosition(Position lineStartPosition) {
        if(lineStartPosition.get() < 0 || lineStartPosition.get() >= nodes.length - 1 || Objects.equals(
                nodes[lineStartPosition.get()], Node.from(Direction.LEFT))
                || Objects.equals(nodes[lineStartPosition.get() + 1], Node.from(Direction.RIGHT))) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DRAW_LINE_POSITION.getErrorMessage());
        }
    }

    public Node[] getNodes() {
        return nodes;
    }
}
