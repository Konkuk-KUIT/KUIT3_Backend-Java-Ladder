package ladder;

public class Row {
    private Node[] node;

    public Row(NaturalNumber naturalNumberOfPerson) {
        node = new Node[naturalNumberOfPerson.getNum()];
        for (int i = 0; i < naturalNumberOfPerson.getNum(); i++){
            node[i] = Node.of(Direction.NONE);
        }
    }


    // 그리기

    public void drawLine(Position lineStartPosition) {
        validateDrawLinePosition(lineStartPosition);
        node[lineStartPosition.getValue()].drawRight();
        node[lineStartPosition.getValue() + 1].drawLeft();
    }

    // 그리기 검사

    private void validateDrawLinePosition(Position lineStartPosition) {
        if(lineStartPosition.getValue() < 0 || lineStartPosition.getValue() >= node.length - 1 || node[lineStartPosition.getValue()].isLeft() || node[lineStartPosition.getValue() + 1].isRight() ) {
            throw new IllegalArgumentException("라인 생성이 불가능한 위치 입니다.");
        }
    }

    // 실행

    public Position nextPosition(Position position) {
        validateNextPosition(position);
        return node[position.getValue()].move(position);
    }

    //실행 검사

    private void validateNextPosition(Position position) {
        if(position.getValue() >= node.length){
            throw new IllegalArgumentException("유효하지 않은 위치입니다.");
        }
    }


    // 실행 출력
    public void printNode(boolean isPositionPrint, Position position){
        for(int i = 0; i < node.length; i++){
            System.out.printf("%2d", node[i].getValue());
            if (isPositionPrint == true && i==position.getValue()){
                System.out.print("* ");
            } else {
                System.out.print("  ");
            }
        }
        System.out.print("\n");
    }



    // 자동 줄 긋기를 위해, node길이 가져오기
    public int getLength(){
        return node.length;
    }



}
