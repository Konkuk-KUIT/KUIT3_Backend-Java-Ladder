package ladder.game;

import ladder.creator.FixedLadderCreator;
import ladder.wrapper.NaturalNumber;
import ladder.creator.LadderCreator;
import ladder.creator.RandomLadderCreator;

public class LadderGameFactory {
    public static LadderGame createRandomLadderGame(NaturalNumber numberOfRows, NaturalNumber numberOfPerson) {
        LadderCreator randomLadderCreator = new RandomLadderCreator();

        return new LadderGame(randomLadderCreator, numberOfRows, numberOfPerson);
    }

    public static LadderGame createFixedLadderGame(NaturalNumber numberOfRows, NaturalNumber numberOfPerson) {
        LadderCreator fixedLadderCreator = new FixedLadderCreator();

        return new LadderGame(fixedLadderCreator, numberOfRows, numberOfPerson);
    }
}
