package ladder.creator;

import ladder.model.LadderSize;
import ladder.model.Position;
import ladder.model.Row;

import java.util.List;

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
    public void drawLine() {
        Position position = Position.fromValue(1);
        rows[0].drawLine(position);
        position = Position.fromValue(1);
        rows[1].drawLine(position);
    }

    @Override
    public Row[] getRows() {
        return rows;
    }
}
