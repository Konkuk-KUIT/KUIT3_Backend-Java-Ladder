package ladder.application;

import ladder.application.creator.LadderCreator;
import ladder.domain.Position;

public class LadderGame {

    private final LadderCreator ladder;

    public LadderGame(LadderCreator ladder) {
        this.ladder = ladder;
    }

    public int run(Position position){
        LadderRunner ladderRunner = new LadderRunner(ladder.getRows());
        return ladderRunner.run(position);
    }

}
