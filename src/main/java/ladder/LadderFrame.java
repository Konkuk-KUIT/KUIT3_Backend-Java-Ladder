package ladder;

public class LadderFrame {

    private Row[] rows;

    public LadderFrame(int numberOfRows, int numberOfPerson) {
        rows = new Row[numberOfRows];

        for(int i = 0; i < numberOfRows; i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    public int getRowsLength() {
        return rows.length;
    }

    public Row getRowOfIndex(int i) {
        return rows[i];
    }
}
