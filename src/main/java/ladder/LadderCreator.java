package ladder;

public class LadderCreator {
    private Row[] rows;

    public LadderCreator(NaturalNumber numberOfRows, NaturalNumber numberOfPerson) {
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
