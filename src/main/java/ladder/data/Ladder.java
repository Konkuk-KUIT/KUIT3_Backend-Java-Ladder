package ladder.data;

import ladder.creator.LadderCreator;
import ladder.runner.LadderRunner;
import type.NaturalNumber;
import type.Position;

public class Ladder {

    LadderRunner ladderRunner;

    public Ladder(LadderCreator ladderCreator) {
        ladderRunner = new LadderRunner(ladderCreator.createLadder());
    }

    public int run(Position position) {
        return ladderRunner.run(position);
    }

}
