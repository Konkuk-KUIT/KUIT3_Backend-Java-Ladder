package ladder;

public class Ladder {

    private Row[] rows;

    public Ladder(int numberOfRows, int numberOfPerson) {
        rows = new Row[numberOfRows];

        for(int i = 0; i < numberOfRows; i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    public void drawLine(int row, int col) {
        rows[row].drawLine(col);
    }

    public Position run(Position position) {

        for(int i = 0; i < rows.length; i++) {
            position = rows[i].nextPosition(position);
        }

        return position;
    }
}
