package ladder.application;

import ladder.model.Row;

public interface LadderCreatorInterface {
    void drawLine(int row, int col);
    Row[] getRows();
}
