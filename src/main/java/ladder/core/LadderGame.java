package ladder.core;

import ladder.position.Position;
import ladder.creator.LadderCreator;

public class LadderGame {

    private final LadderCreator ladderCreator;

    public LadderGame(LadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator;
    }

    public int run(Position position) {
        LadderRunner ladderRunner = new LadderRunner(ladderCreator.getRows());
        return ladderRunner.run(position);
    }

    public boolean isLineDrawn(int i, int j) {
        return ladderCreator.getRows()[i].isLineDrawn(j);
    }
}
