package ladder.game;

import ladder.domain.Position;
import ladder.domain.Row;

public class LadderRunner {
    private Row[] rows;
    public LadderRunner(LadderCreator ladderCreator){
        this.rows = ladderCreator.getRows();
    }

    public Position run(Position position) {
        for(int i = 0; i < rows.length; i++) {
            position = rows[i].nextPosition(position);
        }
        return position;
    }

    public StringBuilder convertRunningToString(Position currentPosition, int curRow){
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < rows.length; i++){
            result.append(rows[i].convertRowToString(currentPosition, i == curRow));
        }
        return result;
    }

    public void showRunning(Position position){
        for(int curRow = 0; curRow < rows.length;){
            System.out.println(convertRunningToString(position, curRow));
            Position prevPosition = position;
            position = rows[curRow].nextPosition(position);
            if(prevPosition.get() == position.get()) {
                curRow++;
            }
        }
    }
}
