package ladder.creator;

import ladder.model.LadderSize;
import ladder.model.Position;
import ladder.model.Row;

import java.util.List;

public class CustomLadderCreator extends LadderCreator{

    @Override
    public void drawLine() {
        Position position = Position.fromValue(1);
        rows[0].drawLine(position);
        position = Position.fromValue(1);
        rows[1].drawLine(position);
    }

    public CustomLadderCreator(LadderSize ladderSize) {
        super(ladderSize); // 부모 클래스의 생성자 호출
    }

    @Override
    public Row[] getRows() {
        return rows;
    }
}
