package ladder;

import ladder.ladderCreator.LadderCreator;

public class LadderGame {

    private final LadderCreator ladderCreator;
    private final LadderRunner ladderRunner;

    public LadderGame(LadderCreator ladderCreator, LadderRunner ladderRunner) {
        this.ladderCreator = ladderCreator;
        this.ladderRunner = ladderRunner;
    }

    public Position play(Position position) {
        ladderCreator.create();

        return ladderRunner.run(position);
    }
}
