package ladder.creator;

import ladder.model.LadderSize;
import ladder.model.Position;
import ladder.model.Row;

import java.util.Random;

public class RandomLadderCreator extends LadderCreator{

    public RandomLadderCreator(LadderSize ladderSize) {
        super(ladderSize); // 부모 클래스의 생성자 호출
    }

    // 사다리 행 * 열 * 0.3
    // 사다리 라인은 겹쳐서 생성될 수 없다. (예외 처리 필요)
    @Override
    public void drawLine() {
        int cnt = getLineCnt();
        int rowCnt = rows.length;
        int colCnt = rows[0].getSize();

        while (cnt > 0) {
            // 무작위로 행과 열을 선택하여 라인을 그림
            Random random = new Random();
            int randomRow = random.nextInt(rowCnt);
            int randomCol = random.nextInt(colCnt-1);

            // 선택된 위치에 이미 라인이 그려져 있는지 확인
            if (!rows[randomRow].isDrawLine(Position.fromValue(randomCol))) {
                // 라인이 겹치지 않는 경우에만 라인 그리기
                rows[randomRow].drawLine(Position.fromValue(randomCol));
                cnt--;
            }
        }
    }

    public int getLineCnt(){
        return (int) Math.round(rows.length * rows[0].getSize() * 0.3);
    }
    @Override
    public Row[] getRows() {
        return rows;
    }
}
