package ladder;

public class Ladder {

    private Row[] rows;

    public Ladder(NaturalNumber numberOfRows, NaturalNumber numberOfPerson) {   // row와 col에 해당하는 사람의 수 까지 입력 받음
        rows = new Row[numberOfPerson.get()];     // Row객체를 가지고 있는 배열의 생성

        for(int i = 0; i < numberOfRows.get(); i++) {
            rows[i] = new Row(numberOfPerson);
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
