package ladder.domain;

import ladder.domain.Direction;

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

    // 정적 팩토리 메소드
    public static Node of(Direction direction) {
        return new Node(direction);
    }
}
