package ladder;

public class LadderSize {
    private final NaturalNumber numberOfRows;
    private final NaturalNumber numberOfColumns;

    public LadderSize(NaturalNumber numberOfRows, NaturalNumber numberOfColumns) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
    }

    public NaturalNumber getNumberOfRows() {
        return numberOfRows;
    }

    public NaturalNumber getNumberOfColumns() {
        return numberOfColumns;
    }
}
