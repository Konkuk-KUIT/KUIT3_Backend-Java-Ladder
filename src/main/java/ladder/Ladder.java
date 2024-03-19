package ladder;

public class Ladder {       // 현재 역할 : 래더 생성, 래더 실행

    private Row[] rows;

    public Ladder(NaturalNumber numberOfRows, NaturalNumber numberOfPerson) {   // row와 col에 해당하는 사람의 수 까지 입력 받음
        rows = new Row[numberOfPerson.get()];     // Row객체를 가지고 있는 배열의 생성

        for(int i = 0; i < numberOfRows.get(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

//    public void drawLine(int row, int col) {
//        rows[row].drawLine(col);
//    }

    public void drawLine(int row, Position col) { // row가 사람 idx란거지~ 확실 x
        rows[row].drawLine(col);
    }

    public Position run(Position position) {  // position이 사람의 index

        for(int i = 0; i < rows.length; i++) {  // 사다리의 높이만큼 반복하는 거잖아
            position = rows[position.get()].slide(position);
        }

        return position;
    }
}
