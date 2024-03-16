package ladder.creator;

import ladder.LadderSize;
import ladder.Position;
import ladder.Row;

public class CustomLadderCreator implements LadderCreator{
    Row[] rows;
    public CustomLadderCreator(LadderSize ladderSize) {
        ladderSize.validate();
        rows = new Row[ladderSize.getNumberOfRows()];

        for(int i = 0; i < ladderSize.getNumberOfRows(); i++) {
            rows[i] = new Row(ladderSize.getNumberOfPerson());
        }
    }
    @Override
    public void drawLine(int row, int col) {
        Position position = new Position(col);
        rows[row].drawLine(position);
    }
}
