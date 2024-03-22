package ladder;

public class LadderCreator {
    private Row[] rows;

    public LadderCreator(NaturalNumber numberOfRows, NaturalNumber numberOfPerson) {
        rows = new Row[numberOfPerson.getValue()];

        for (int i = 0; i < numberOfRows.getValue(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    public void drawLine(int row, int col) {
        rows[row].drawLine(Position.of(col));
    }

    public Row[] getRows() {
        return rows;
    }
}
