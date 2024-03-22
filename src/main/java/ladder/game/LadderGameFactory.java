package ladder.game;

import ladder.creator.RandomLadderCreator;
import ladder.creator.SetUpLadderCreator;
import ladder.runner.LadderRunner;
import type.NaturalNumber;

public class LadderGameFactory {

    public static LadderGame createRandomLadderGame(NaturalNumber numberOfRows, NaturalNumber numberOfPersons) {
        return new LadderGame(new RandomLadderCreator(numberOfRows, numberOfPersons));
    }

    public static LadderGame createSetUpLadderGame(NaturalNumber numberOfRows, NaturalNumber numberOfPersons) {
        return new LadderGame(new SetUpLadderCreator(numberOfRows, numberOfPersons));
    }

}
