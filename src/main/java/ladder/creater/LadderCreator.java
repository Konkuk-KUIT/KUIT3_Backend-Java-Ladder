package ladder.creater;

import ladder.core.NaturalNumber;
import ladder.core.Row;
import ladder.position.LadderPosition;
import ladder.position.Position;

public class LadderCreator {

    private Row[] rows;
    int peoplenum;

    public int getPeoplenum() {
        return peoplenum;
    }

    public LadderCreator(NaturalNumber numberOfRows, NaturalNumber numberOfPerson) {
        peoplenum = numberOfPerson.get();
        rows = new Row[numberOfPerson.get()];

        for(int i = 0; i < numberOfRows.get(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    public void drawLine(Position row, Position col) {
        rows[row.getPosition()].drawLine(col);
    }

    public Row[] getRows() {
        return rows;
    }
}
