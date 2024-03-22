package ladder;

public class Row {
    private final Node[] nodes;

    public Row(NaturalNumber numberOfPerson) {
        nodes = new Node[numberOfPerson.get()];     // TODO: node들의 배열에서 각 노드들 초기화 해줘야 하는가?
        init();
    }

    private void init() {
        for(int i  = 0; i < nodes.length; i++) {
            nodes[i] = Node.from(Direction.CENTER);
        }
    }

    public void drawLine(Position lineStartPosition) {   // 오른쪽 찍 한줄 긋기
        nodes[lineStartPosition.get()] = Node.from(Direction.RIGHT);
        nodes[lineStartPosition.next().get()] = Node.from(Direction.LEFT);
    }

    public Position slide(Position position) {
        return nodes[position.get()].move(position);
    }

    public int getNodesLength() {
        return nodes.length;
    }

    public int getNodesDirectionValue (int position) {
        return nodes[position].getDirectionValue();
    }

    public Direction getNodesDirection(Position position) {
        return nodes[position.get()].getDirection();
    }
}
