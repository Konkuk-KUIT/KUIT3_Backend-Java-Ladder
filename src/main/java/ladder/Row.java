package ladder;

import Numbers.NaturalNum;
import Numbers.Number;
import Numbers.Position;

import java.util.Vector;

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

    public int getRowSize(){
        return nodes.length;
    }

    public void drawLine(Number lineStartPosition) {
        validateDrawLine(lineStartPosition);
        /* row[lineStartPosition] = 1;
        row[lineStartPosition + 1] = -1;*/

        //validate
        nodes[lineStartPosition.get()] = Node.SetNode(Direction.RIGHT);
        nodes[lineStartPosition.get()+1] = Node.SetNode(Direction.LEFT);
    }

    public boolean drawRandomLine(){

        //라인을 그릴 자리가 있는지 확인
        int checker = 0;
        Vector<Integer> leftNode = new Vector<Integer>();
        for(int i=0;i<nodes.length;i++){
            if(nodes[i].isnone()){
                checker++;
            }else{
                checker = 0;
                continue;
            }

            if(checker >= 2){
                leftNode.add(i-1);

            }
        }
        if(leftNode.size()==0){
            return false;
        }

        //남은 자리중 라인 그리기
        int targetNode  = (int)(Math.random()*(leftNode.size()+1-1));
        //System.out.printf("NodeNUM : %d",leftNode.size());
        //System.out.printf("target : %d",targetNode);

        this.drawLine(Position.of(leftNode.get(targetNode)));
        return true;
    }

    public Position nextPosition(Position position) {
        validatePosition(position);
        //Direction Dir = nodes[position.getPosition()].NextPosition();

        //Position POSITION = Position.of(position/*, nodes.length*/);
        Position nextPosition = nodes[position.get()].Move(position);
        return nextPosition;
    }

    public void printRow(Number position, String marker){

        for(int i=0;i< nodes.length;i++){
            System.out.printf("%2d", nodes[i].getDirNum() );
            if( (position!=null) && i ==position.get()){
                System.out.printf("%s",marker);
            }else{
                System.out.printf(" ");
            }
        }
        System.out.printf("\n");
    }

    private void validateDrawLine(Number linestartposition)throws IllegalArgumentException{
        if((nodes.length-2<linestartposition.get()||linestartposition.get()<0)){
            throw new IllegalArgumentException("선을 그릴 수 없는 위치입니다.");
        }
        if(Direction.NONE!=nodes[linestartposition.get()].NextPosition()||Direction.NONE!=nodes[linestartposition.get()+1].NextPosition()){
            throw new IllegalArgumentException("이미 선이 있는 위치 입니다.");
        }
    }

    private void validatePosition(Number position) throws IllegalArgumentException{
        if(position.get() > nodes.length-1||position.get()<0){
            throw new IllegalArgumentException("유효하지 않은 위치입니다");
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
