package ladder;

public class Ladder {
    private Row[] rows;

    public Ladder(NaturalNumber numberOfRows, NaturalNumber numberOfPerson) {
        rows = new Row[numberOfRows.get()];

        for (int i = 0; i < numberOfRows.get(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    public void drawLine(Position row, Position col) {
        rows[row.get()].drawLine(col);
    }

    public Row[] getRows() {
        return rows;
    }

    public String printLadder() {
        StringBuilder ladderResult = new StringBuilder();
        for (Row row : rows) {
            ladderResult.append(row.printRow());
        }
        return ladderResult.toString();
    }
}
