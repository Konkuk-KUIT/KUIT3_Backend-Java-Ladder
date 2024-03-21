package ladder;

public class Ladder {

    private Row[] rows;

    public Ladder(NaturalNumber numberOfRows, NaturalNumber numberOfPerson) {
        rows = new Row[numberOfPerson.get()];

        for(int i = 0; i < numberOfRows.get(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }


    public void drawLine(Position row, Position col) {
        rows[row.getPosition()].drawLine(col);
    }

    public Position run(Position position) {

        for(int i = 0; i < rows.length; i++) {
            position = rows[i].nextPosition(position);
        }

        return position;
    }

    // Ladder 클래스 내부에 추가
    public void printLadder() {
        for (Row row : rows) {
            System.out.println(row.toString());
        }
    }
}
