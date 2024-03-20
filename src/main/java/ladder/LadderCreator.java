package ladder;

public class LadderCreator {
    private final Row[] rows;

    public LadderCreator(NaturalNumber numberOfRow, NaturalNumber numberOfPerson) {
        rows = new Row[numberOfRow.getNum()];

        for(int i=0;i< numberOfRow.getNum();i++){
            rows[i] = new Row(numberOfPerson);
        }
    }

    public Row[] getRows() {
        return rows;
    }

    public void drawLine(Position row, Position col) {
        rows[row.getPosition()].drawLine(col);
    }
}
