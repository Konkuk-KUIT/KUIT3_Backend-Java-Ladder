package ladder.game;

import ladder.data.Ladder;
import ladder.creator.LadderCreator;
import type.Position;

public class LadderGame {
    Ladder ladder;

    public LadderGame(LadderCreator ladderCreator) {
        ladder = new Ladder(ladderCreator);
    }

    public void play(Position position) {
        ladder.run(position);
    }

}
