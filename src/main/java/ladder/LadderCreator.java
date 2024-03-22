package ladder;

public class LadderCreator {

    private final Row[] rows;
    public LadderCreator(NaturalNumber numberOfRow, NaturalNumber numberOfPerson) {
        rows = new Row[numberOfRow.get()];

        for (int i = 0; i < numberOfRow.get(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    public Row[] getRows() {
        return rows;
    }

    public int getIntOfPerson() {
        return rows[0].getRowToString().length;
    }

    public int getIntOfRow() {
        return rows.length;
    }

    public void drawLine(Position row, Position col) {
        rows[row.getValue()].drawLine(col);
    }

}
