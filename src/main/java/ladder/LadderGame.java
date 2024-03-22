package ladder;

import ladder.ladderCreator.LadderCreator;
import ladder.wrapper.Position;
import ladder.wrapper.Row;

public class LadderGame {

    private final LadderCreator ladderCreator;

    public LadderGame(LadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator;
    }

    public Position play(Position position) {
        Row[] rows = ladderCreator.create();

        LadderRunner ladderRunner = new LadderRunner(rows);

        return ladderRunner.run(position);
    }
}
