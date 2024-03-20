package ladder;

import ladder.NaturalNumber;

public class Ladder {

    private Row[] rows; //선언
//    int[] arr = new int[5]; // 5칸인 배열을 생성 (다 0으로 초기화됨)
//    Row[] rows = new Row[n]       // 크기가 n인 Row배열을 만듦

    public Ladder(NaturalNumber numberOfRows, NaturalNumber numberOfPerson) {
        rows = new Row[numberOfPerson.getValue()]; // 초기화
        //    Row[] rows = new Row[n]  : 크기가 n인 Row배열을 만듦

        for(int i = 0; i < numberOfRows.getValue(); i++) {
            rows[i] = new Row(numberOfPerson.getValue());          // new Row() : Row 객체를 만들어서 rows의 각 칸에 하나씩 넣어줌


//            Row row1 = new Row(numberOfPerson);     // 생성자를 통한 객체 생성
//            rows[i] = row1;       // 배열 각 칸에 만든 객체를 넣어줌
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
