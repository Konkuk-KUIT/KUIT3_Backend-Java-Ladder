package ladder;

public class LadderPrinter implements Printer {
    private Row[] rows;

    public LadderPrinter(Row[] rows) {
        this.rows = rows;
    }

    @Override
    public String print() {
        StringBuilder ladderResult = new StringBuilder();
        for (Row row : rows) {
            ladderResult.append(row.printRow());
        }
        return ladderResult.toString();
    }
}
