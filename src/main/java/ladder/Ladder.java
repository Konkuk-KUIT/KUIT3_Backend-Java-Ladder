package ladder;

public class Ladder {

    private Row[] rows;

    public Ladder(NaturalNumber numberOfRows, NaturalNumber numberOfPerson) {
        rows = new Row[numberOfPerson.getNum()];

        for(int i = 0; i < numberOfRows.getNum(); i++) {
            rows[i] = new Row(numberOfPerson.getNum());
        }
    }

    public void drawLine(NaturalNumber row, NaturalNumber col) {
        rows[row.getNum()].drawLine(col.getNum());
    }

    public int run(int position) {

        for(int i = 0; i < rows.length; i++) {
            position = rows[i].nextPosition(position);
        }

        return position;
    }
}
