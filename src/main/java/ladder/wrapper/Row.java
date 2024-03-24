package ladder.wrapper;

public class Row {
    private final Node[] nodes;

    public Row(NaturalNumber numberOfPerson) {
        nodes = new Node[numberOfPerson.get()];
        init();
    }

    private void init() {
        for(int i  = 0; i < nodes.length; i++) {
            nodes[i] = Node.from(Direction.CENTER);
        }
    }

    public void drawLine(Position lineStartPosition) {
        nodes[lineStartPosition.get()] = Node.from(Direction.RIGHT);
        nodes[lineStartPosition.next().get()] = Node.from(Direction.LEFT);
    }

    public void drawLine(int position) {
        nodes[position] = Node.from(Direction.RIGHT);
        nodes[position + 1] = Node.from(Direction.LEFT);
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
