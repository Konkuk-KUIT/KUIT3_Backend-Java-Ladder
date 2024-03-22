package ladder.application;

import ladder.domain.NaturalNumber;
import ladder.domain.Position;
import ladder.domain.Row;

public class LadderCreator {
    private Row[] rows;

    public LadderCreator(NaturalNumber numberOfRows, NaturalNumber numberOfPerson) {
        rows = new Row[numberOfPerson.getNum()];

        for(int i = 0; i < numberOfRows.getNum(); i++) {
            rows[i] = new Row(numberOfPerson.getNum());
        }
    }

    public void drawLine(Position row, Position col) {
        rows[row.getPosition()].drawLine(col.getPosition());
    }
}
