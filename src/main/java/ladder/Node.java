package ladder;

public class Node {
    private int node;

    public Node(int node) {
        this.node = node;
    }

    public int value() {
        return node;
    }

    public void setGoLeft() {
        node = -1;
    }

    public void setGoRight() {
        node = 1;
    }
}
