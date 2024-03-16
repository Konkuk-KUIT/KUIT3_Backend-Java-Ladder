package ladder.game;

import ladder.LadderSize;
import ladder.creator.CustomLadderCreator;

public class LadderGameFactory {
    public static LadderGame customLadderGame(LadderSize ladderSize) {
        CustomLadderCreator customLadderCreator = new CustomLadderCreator(ladderSize);
        return new LadderGame(customLadderCreator);
    }
}
