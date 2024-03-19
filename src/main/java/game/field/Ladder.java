package game.field;

import game.fieldComponent.Row;

public class Ladder implements Field {

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


    @Override
    public int run(int... position) {
        for(int i = 0; i < rows.length; i++) {

            position[0] = rows[i].nextPosition(position[0]);
        }

        return position[0];
    }
}
