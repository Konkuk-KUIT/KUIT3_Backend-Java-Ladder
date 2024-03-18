package ladder.ladderCreator;

import ladder.Ladder;
import ladder.LadderSpec;

public interface LadderCreator {

    Ladder create(LadderSpec ladderSpec);
}
