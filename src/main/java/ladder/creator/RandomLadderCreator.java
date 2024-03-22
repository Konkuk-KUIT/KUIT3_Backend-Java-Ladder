package ladder.creator;

import ladder.data.Row;
import type.NaturalNumber;
import type.Position;

public class RandomLadderCreator implements LadderCreator {

    private Row[] rows;
    NaturalNumber numberOfRows;
    NaturalNumber numberOfPersons;

    public RandomLadderCreator(NaturalNumber numberOfRows, NaturalNumber numberOfPersons) {
        this.numberOfRows = numberOfRows;
        this.numberOfPersons = numberOfPersons;
    }

    @Override
    public Row[] createLadder() {
        rows = new Row[numberOfRows.getValue()];

        for(Position i = new Position(0); i.getPosition() < numberOfRows.getValue(); i.increase()) {
            rows[i.getPosition()] = new Row(numberOfPersons);
        }

        int tmp = (int)(numberOfPersons.getValue() * numberOfRows.getValue() * 0.3);
        while(tmp > 0) {
            try {
                tmp--;
                int r = (int)(Math.random() * numberOfRows.getValue());
                int p = (int)(Math.random() * numberOfPersons.getValue());
                drawLine(new Position(r), new Position(p));
            } catch(Exception e) {
                tmp++;
            }
        }

        return rows;
    }

    public void drawLine(Position row, Position col) {
        rows[row.getPosition()].drawLine(col);
    }

}
