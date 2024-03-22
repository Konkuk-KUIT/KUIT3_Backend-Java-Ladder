package ladder.application;

import ladder.domain.Position;
import ladder.domain.Row;

public class LadderRunner {

    private final Row[] rows;

    LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(Position position) {

        for(int i = 0; i < rows.length; i++) {
            position = rows[i].nextPosition(position);
        }

        return position.getValue();
    }
}