package ladder;

public class Ladder {

    private Row[] rows;

    public Ladder(NaturalNumber numberOfRows, NaturalNumber numberOfPerson) {
        rows = new Row[numberOfPerson.getNumber()];

        for(int i = 0; i < numberOfRows.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    public void drawLine(Position row, Position col) {
        rows[row.getValue()].drawLine(col);
    }

    public int run(Position position) {

        for(int i = 0; i < rows.length; i++) {
            position = rows[i].nextPosition(position);
        }

        return position.getValue();
    }
}
