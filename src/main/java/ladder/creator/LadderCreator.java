package ladder.creator;

import ladder.Ladder;
import ladder.wrapper.NaturalNumber;

public interface LadderCreator {
    Ladder createLadder(NaturalNumber numberOfRows, NaturalNumber numberOfPerson);
}
