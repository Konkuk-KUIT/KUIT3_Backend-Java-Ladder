package ladder;

public class LadderRunner {
    Row[] rows;
    public LadderRunner(Row[] rows){
        this.rows = rows;
    }

    public int run(Position position) {

        for(int i = 0; i < rows.length; i++) {
            printLadderLine(LadderPosition.fromCoordinate(Position.fromValue(i),position));
            position = rows[i].nextPosition(position);
            printLadderLine(LadderPosition.fromCoordinate(Position.fromValue(i),position));
        }

        return position.getPosition();
    }

    public void printLadderLine(LadderPosition ladderPosition){
        for(int i=0;i< rows.length;i++){
            StringBuilder sb = new StringBuilder();
            rows[i].printRow(sb,Position.fromValue(i),ladderPosition);
        }
    }
}
