package ladder;

public class Ladder {

    private Row[] rows;

    public Ladder(NaturalNumber numberOfRows, NaturalNumber numberOfPerson) {
        rows = new Row[numberOfPerson.getValue()];

        for (int i = 0; i < numberOfRows.getValue(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }


    public void drawLine(int row, int col) {
        rows[row].drawLine(Position.of(col));
    }

    public Position run(Position position) {

        for (int i = 0; i < rows.length; i++) {
            position = rows[i].nextPosition(position);
        }
        return position;
    }
}
