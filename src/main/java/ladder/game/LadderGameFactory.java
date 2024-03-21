package ladder.game;

import ladder.wrapper.NaturalNumber;
import ladder.creator.LadderCreator;
import ladder.creator.RandomLadderCreator;

public class LadderGameFactory {
    public static LadderGame createRandomLadderGame(NaturalNumber numberOfRows, NaturalNumber numberOfPerson) {
        LadderCreator ladderRandomCreator = new RandomLadderCreator();

        return new LadderGame(ladderRandomCreator, numberOfRows, numberOfPerson);
    }
}
