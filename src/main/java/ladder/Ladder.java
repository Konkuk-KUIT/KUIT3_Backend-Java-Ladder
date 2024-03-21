package ladder;

public class Ladder {

    private Row[] rows;

    // 사다리 생성
    public Ladder(int numberOfRows, int numberOfPerson) {
        rows = new Row[numberOfPerson];

        for(int i = 0; i < numberOfRows; i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    // 사다리 라인 그리기
    // row번째 줄의 col행 - col+1 행에 사다리 라인 그리기
    public void drawLine(int row, int col) {
        rows[row].drawLine(col);
    }

    // 사다리 게임 실행
    public int run(int position) {

        for(int i = 0; i < rows.length; i++) {
            position = rows[i].nextPosition(position);
        }

        return position;
    }
}
