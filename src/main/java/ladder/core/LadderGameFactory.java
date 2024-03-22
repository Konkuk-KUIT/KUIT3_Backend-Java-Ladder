package ladder.core;

import ladder.creator.CustomLadderCreator;
import ladder.creator.RandomLadderCreator;

public class LadderGameFactory {
    private LadderGameFactory() {}
    public static LadderGame randomLaddergame(LadderSize ladderSize) {
        CustomLadderCreator customLadderCreator = new CustomLadderCreator(ladderSize);
        RandomLadderCreator randomLadderCreator = new RandomLadderCreator(customLadderCreator);
        return new LadderGame(randomLadderCreator);
    }

    static LadderGame customLadderGame(LadderSize ladderSize) {
        CustomLadderCreator customLadderCreator = new CustomLadderCreator(ladderSize);
        return new LadderGame(customLadderCreator);
    }
}