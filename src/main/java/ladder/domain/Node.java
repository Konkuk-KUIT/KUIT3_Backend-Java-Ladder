package ladder.domain;

public class Node {
    Direction node;

    public Node(Direction node){
        this.node = node;
    }

    public void set(Direction node){
        this.node = node;
    }

    public boolean isLeft(){
        if(node == Direction.LEFT){
            return true;
        }
        return false;
    }

    public boolean isRight(){
        if(node == Direction.RIGHT){
            return true;
        }
        return false;
    }
    public Position move(Position position){
        if(isLeft()){
            return position.prev();
        }
        if(isRight()){
            return position.next();
        }
        return position;
    }

    public int get(){
        return node.getDirection();
    }
}
