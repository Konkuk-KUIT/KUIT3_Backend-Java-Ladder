package ladder.application;

import ladder.application.LadderCreatorInterface;
import ladder.application.LadderRunner;
import ladder.model.Position;

public class LadderGame {
    private final LadderCreatorInterface ladderCreator;

    public LadderGame(LadderCreatorInterface ladderCreator) {
        this.ladderCreator = ladderCreator;
    }

    public Position runGame(Position startPosition) {
        LadderRunner runner = new LadderRunner(ladderCreator.getRows());
        return runner.run(startPosition);
    }
}