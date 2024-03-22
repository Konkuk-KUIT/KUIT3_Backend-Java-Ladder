package ladder.game;

import ladder.domain.Position;
import ladder.domain.Row;

public class LadderRunner {
    private Row[] rows;
    public LadderRunner(LadderCreator ladderCreator){
        this.rows = ladderCreator.getRows();
    }

    public Position run(Position position) {
        for(int i = 0; i < rows.length; i++) {
            position = rows[i].nextPosition(position);
        }
        return position;
    }
}
