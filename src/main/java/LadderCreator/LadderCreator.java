package LadderCreator;

import ladder.Row;
import model.LadderPosition;
import model.LadderSize;
import model.NaturalNumber;
import model.Position;

public abstract class LadderCreator {
    public abstract void drawLine(Position row, Position col);
    public abstract Row[] getRows();
    abstract public String createStringLadder(LadderPosition lp);
}
