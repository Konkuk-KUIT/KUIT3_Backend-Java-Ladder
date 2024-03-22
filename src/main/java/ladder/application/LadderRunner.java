package ladder.application;

import ladder.domain.Position;
import ladder.domain.Row;

public class LadderRunner {

    private final Row[] rows;

    LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    // 현재 포지션 입력하면 최종 포지션 출력
    public int run(Position position) {

        for(int i = 0; i < rows.length; i++) {
            position = rows[i].nextPosition(position);
        }

        return position.getValue();
    }
}