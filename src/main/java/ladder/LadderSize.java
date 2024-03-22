package ladder;

import domain.NaturalNumber;

public class LadderSize {
    private NaturalNumber row;
    private NaturalNumber col;
    private final double RATIO = 0.3;

    public LadderSize(NaturalNumber row, NaturalNumber col) {
        this.row = row;
        this.col = col;
    }

    public int countLines(){
        return (int) (row.getNum() * col.getNum() * RATIO);
    }

    public NaturalNumber getRow() {
        return row;
    }

    public NaturalNumber getCol() {
        return col;
    }
}
