package ladder;

public class LadderRunner {
    private final Row[] rows;

    public LadderRunner(LadderCreator ladderCreator){
        this.rows = ladderCreator.getRows();
    }
    public int run(Position position){

        //아직 검증되지 않아서 주석처리
        //printLadder(position);

        for(int i =0; i < rows.length; i++){
            position = rows[i].nextPosition(position);
        }
        //마지막으로 도착한 position return
        return position.getPosition();
    }
    //사다리 print하기 위한 메소드
    private void printLadder(Position position) {
        String[][] strings = new String[rows.length][];
        for(int i = 0; i< rows.length; i++){
            strings[i] = rows[i].getNodesToString();
        }
        for(int i =0; i< strings.length; i++){
            for(int j =0; j< strings[i].length; j++){
                System.out.print(strings[i][j]);
            }
            System.out.println();
        }
    }
}
