package ladder;

public class LadderSize {
    private final int rows;
    private final int columns;

    public LadderSize(NaturalNumber rows, NaturalNumber columns) {
        this.rows = rows.get();
        this.columns = columns.get();
    }
    public int calculateLines() {
        return (int) (rows * columns * 0.3);
    }
}
