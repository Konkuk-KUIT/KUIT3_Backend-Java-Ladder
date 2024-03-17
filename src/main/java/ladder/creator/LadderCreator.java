package ladder.creator;

import ladder.Position;
import ladder.Row;

public interface LadderCreator {
    public void drawLine(int row, int col);

    Row[] getRows();
}
