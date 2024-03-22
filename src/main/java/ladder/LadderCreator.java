package ladder;

import domain.NaturalNumber;
import domain.Position;
import domain.Row;

public class LadderCreator {
    private Row[] rows;
    public LadderCreator(NaturalNumber numberOfRows, NaturalNumber numberOfPerson) {
        rows = new Row[numberOfPerson.getNum()];

        for(int i = 0; i < numberOfRows.getNum(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    public void drawLine(Position row, Position col) {
        rows[row.getPosition()].drawLine(col);
    }

    public Row[] getRows(){
        return rows;
    }
}
