package ladder;

public class Ladder {
    private Row[] rows;
    private Printer ladderPrinter;

    public Ladder(NaturalNumber numberOfRows, NaturalNumber numberOfPerson) {
        rows = new Row[numberOfRows.get()];
        for (int i = 0; i < numberOfRows.get(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
        ladderPrinter = new LadderPrinter(rows);
    }

    public void drawLine(Position row, Position col) {
        rows[row.get()].drawLine(col);
    }

    public Row[] getRows() {
        return rows;
    }

    public String printLadder() {
        return ladderPrinter.print();
    }
}
