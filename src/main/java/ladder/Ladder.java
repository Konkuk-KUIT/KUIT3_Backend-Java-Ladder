package ladder;

public class Ladder {
    private Row[] rows;

    public Ladder(NaturalNumber numberOfRows, NaturalNumber numberOfPerson) {  // 자연수
        rows = new Row[numberOfRows.get()];

        for(int i = 0; i < numberOfRows.get(); i++) {
            rows[i] = new Row(numberOfPerson.get());
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
