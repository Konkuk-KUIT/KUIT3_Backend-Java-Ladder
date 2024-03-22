package ladder;

public class Row {
    private Node[] nodes;

    public Row(NaturalNumber naturalCol) {
        nodes = new Node[naturalCol.getNum()];
        for (int i =0 ; i<naturalCol.getNum(); i++){
            nodes[i] = Node.of(Direction.STAY);
        }
    }

    public void drawLine(Position position) {
        validateDrawLinePosition(position);
        nodes[position.getPosition()] = Node.of(Direction.RIGHT);
        nodes[position.next().getPosition()] = Node.of(Direction.LEFT);
    }

    public Position nextPosition(Position position) {
        validatePosition(position);
        return nodes[position.getPosition()].move(position);
    }


    private void validateDrawLinePosition(Position position) {
        if(position.getPosition() < 0 || position.getPosition() > (nodes.length - 2) || nodes[position.getPosition()].isRight() || nodes[position.next().getPosition()].isRight() || nodes[position.getPosition()].isLeft()) {
            throw new IllegalArgumentException(ExceptionMessage.INVAILD_LADDER_DRAW_POSITION.getValue());
        }
    }

    private void validatePosition(Position position) {
        if(position.getPosition() >= nodes.length || position.getPosition() < 0 ) {
            throw new IllegalArgumentException(ExceptionMessage.INVAILD_LADDER_POSITION.getValue());
        }
    }

    //print를 위한 함수
    public String[] getNodesToString(Position position){
        String[] str = new String[nodes.length];
        for(int i = 0; i < nodes.length; i++){
            if(nodes[i].isRight()) {
                str[i] = " 1 ";
            }else if (nodes[i].isLeft()) {
                str[i] = "-1 ";
            }else {
                str[i] = " 0 ";
            }
//            if(IsCurrentPosition(i, position))
//                str[i] += "*";
//            else
//                str[i] += " ";
        }
        return str;
    }
    private boolean IsCurrentPosition(int i, Position position){
        return i==position.getPosition();
    }

    public Node[] getNodes() {
        return nodes;
    }
}
