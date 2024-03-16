package ladder;

public class Ladder {

    private Row[] rows;

    public Ladder(LadderSize ladderSize) {
        ladderSize.validate();
        rows = new Row[ladderSize.getNumberOfRows()];

        for(int i = 0; i < ladderSize.getNumberOfRows(); i++) {
            rows[i] = new Row(ladderSize.getNumberOfPerson());
        }
    }

    public void drawLine(int row, int col) {
        Position position = new Position(col);
        rows[row].drawLine(position);
    }

    public int run(Position position) {

        for(int i = 0; i < rows.length; i++) {
            position = rows[i].nextPosition(position);
        }

        return position.getPosition();
    }
}
