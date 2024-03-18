package ladder;

public class Ladder {

    private Row[] rows;

    public Ladder(NaturalNumber numberOfRows, NaturalNumber numberOfPersons) {
        rows = new Row[numberOfRows.toInt()];

        for(int i = 0; i < numberOfRows.toInt(); i++) {
            rows[i] = new Row(numberOfPersons.toInt());
        }
    }

    public void drawLine(int row, int col) {
        rows[row].drawLine(col);
    }

    public int run(int position) {

        for(int i = 0; i < rows.length; i++) {
            position = rows[i].nextPosition(position);
        }

        return position;
    }
}
