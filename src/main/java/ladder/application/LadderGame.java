package ladder.application;

import ladder.creater.LadderCreator;
import ladder.position.Position;

public class LadderGame {
    private final LadderCreator ladderCreator;

    public LadderGame(LadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator;
    }

    public int run(Position position) {
        int numberOfPersons = ladderCreator.getPeoplenum();
        if (position.isBiggerThan(numberOfPersons)) {
            throw new IllegalArgumentException();
        }
        LadderRunner ladderRunner = new LadderRunner(ladderCreator.getRows());
        return ladderRunner.run(position);
    }

}
