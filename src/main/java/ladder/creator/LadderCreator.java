package ladder.creator;

import ladder.model.LadderSize;
import ladder.model.Row;

public abstract class LadderCreator {
    protected final Row[] rows;
    public abstract void drawLine();

    public LadderCreator(LadderSize ladderSize) {
        rows = new Row[ladderSize.getNumberOfRows()];

        for(int i = 0; i < ladderSize.getNumberOfRows(); i++) {
            rows[i] = new Row(ladderSize.getNumberOfPerson());
        }
    }



    abstract public Row[] getRows();
}
