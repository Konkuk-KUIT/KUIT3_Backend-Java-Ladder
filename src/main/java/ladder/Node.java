package ladder;

public class Node {
    private final Direction nodeDirection;

//    private validateNode(int node){
//        if(){
//            throw new IllegalArgumentException()
//        }
//    }

    private Node(Direction nodeDirection){
//        validateNode(node);
        this.nodeDirection = nodeDirection;
    }

    public Direction getNode() {
        return nodeDirection;
    }
}
