package ladder.creator;

import ladder.model.Row;

public interface LadderCreator {
    public void drawLine(int row, int col);

    Row[] getRows();
}
