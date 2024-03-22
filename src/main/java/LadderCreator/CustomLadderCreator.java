package LadderCreator;

import ladder.Row;
import model.LadderPosition;
import model.LadderSize;
import model.Position;

public class CustomLadderCreator extends LadderCreator{
    private final Row[] rows;
    private final LadderSize ls;
    public CustomLadderCreator(LadderSize ls){
        this.ls = ls;
        rows = new Row[ls.getRow().getNaturalNumber()];
        for(int i = 0; i < rows.length; i++) {
            rows[i] = new Row(ls.getPersons());
        }
    }
    public String createStringLadder(LadderPosition lp){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < rows.length; i++) {
            sb.append(rows[i].createRowString(lp,i)).append('\n');
        }
        return sb.toString();
    }

    @Override
    public void drawLine(Position row, Position col) {
        rows[row.getPosition()].drawLine(col);
    }

    @Override
    public Row[] getRows() {
        return rows;
    }
}
