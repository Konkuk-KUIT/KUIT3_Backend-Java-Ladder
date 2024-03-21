package ladder.application;

import ladder.application.LadderCreator;
import ladder.application.LadderGame;
import ladder.model.LadderSize;
import ladder.model.NaturalNumber;

import java.util.Random;
public class LadderGameFactory {
    public enum CreatorType {
        REGULAR, AUTO
    }

    public static LadderGame createLadderGame(int numberOfRow, int numberOfPerson, CreatorType creatorType) {
        LadderCreatorInterface ladderCreator;

        switch (creatorType) {
            case AUTO:
                ladderCreator = new LadderAutoCreator(NaturalNumber.of(numberOfRow), NaturalNumber.of(numberOfPerson));
                break;
            case REGULAR:
            default:
                ladderCreator = new LadderCreator(NaturalNumber.of(numberOfRow), NaturalNumber.of(numberOfPerson));
                break;
        }

        return new LadderGame(ladderCreator);
    }
}
