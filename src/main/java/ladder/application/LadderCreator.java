package ladder.application;


import ladder.model.NaturalNumber;
import ladder.model.Row;

public class LadderCreator implements LadderCreatorInterface {
    private Row[] rows;


    public LadderCreator(NaturalNumber numberOfRow, NaturalNumber numberOfPerson) {
        rows = new Row[numberOfRow.get()];
        for (int i = 0; i < numberOfRow.get(); i++) {
            rows[i] = new Row(numberOfPerson.get());
        }
    }

    public void drawLine(int row, int col) {
        rows[row].drawLine(col);
    }

    public Row[] getRows() {
        return rows;
    }

}
