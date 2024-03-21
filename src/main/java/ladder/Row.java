package ladder;

import Numbers.NaturalNum;
import Numbers.Number;
import Numbers.Position;

public class Row {
    /*private int[] row;*/
    private Node[] nodes;

    public Row(NaturalNum numberOfPerson) {
        //validateNumberOfPerson(numberOfPerson);
        /*row = new int[numberOfPerson];*/

        nodes = new Node[numberOfPerson.get()];
        for(int i=0;i<numberOfPerson.get();i++){
            nodes[i] = Node.SetNode(Direction.NONE);
        }

    }

    public void drawLine(Number lineStartPosition) {
        validateDrawLine(lineStartPosition);
        /* row[lineStartPosition] = 1;
        row[lineStartPosition + 1] = -1;*/

        //validate
        nodes[lineStartPosition.get()] = Node.SetNode(Direction.RIGHT);
        nodes[lineStartPosition.get()+1] = Node.SetNode(Direction.LEFT);
    }

    public int nextPosition(int position) {
        //validatePosition(position);
        //Direction Dir = nodes[position.getPosition()].NextPosition();
        Position POSITION = Position.of(position, nodes.length);
        Position nextPosition = nodes[POSITION.get()].Move(POSITION);
        return nextPosition.get();
    }

    private void validateDrawLine(Number linestartposition)throws IllegalArgumentException{
        if((nodes.length-2<linestartposition.get()||linestartposition.get()<0)){
            throw new IllegalArgumentException("선을 그리는 위치가 잘못 되었습니다.");
        }
        if(Direction.NONE!=nodes[linestartposition.get()].NextPosition()||Direction.NONE!=nodes[linestartposition.get()+1].NextPosition()){
            throw new IllegalArgumentException("선을 그리는 위치가 잘못 되었습니다.");
        }
    }
    /*private boolean isLeft(int position) {
        return row[position] == -1;
    }

    private boolean isRight(int position) {
        return row[position] == 1;
    }
*/
    /*private void validateNumberOfPerson(int numberOfPerson) {
        if(numberOfPerson < 1) {
            throw new IllegalArgumentException("게임의 참여자 수는 1명 이상이어야 합니다.");
        }
    }
*/
    private void validateDrawLinePosition(int lineStartPosition) {
        /*if(lineStartPosition < 0 || lineStartPosition >= row.length - 1 || row[lineStartPosition] == -1 || row[lineStartPosition + 1] == 1) {
            throw new IllegalArgumentException("라인 생성이 불가능한 위치 입니다.");
        }*/

    }

    private void validatePosition(int position) {
        /*
        if(position >= row.length || position < 0 ) {
            throw new IllegalArgumentException("유효하지 않은 위치 입니다.");
        }
        */

    }




}
