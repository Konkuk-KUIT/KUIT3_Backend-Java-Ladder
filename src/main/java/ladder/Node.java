package ladder;

public class Node {
    final Direction Dir;

    private Node(Direction dir){
        Dir = dir;
    }

    public static Node SetNode(Direction Dir){
        return new Node(Dir);
    }

    public Direction NextPosition(){
        return Dir;
    }
}
