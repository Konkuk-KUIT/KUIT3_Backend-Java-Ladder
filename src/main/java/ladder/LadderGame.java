package ladder;

import ladder.ladderCreator.LadderCreator;

public class LadderGame {

    private final LadderCreator ladderCreator;

    public LadderGame(LadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator;
    }

    public void run() {

    }

    private void createLadder() {
        ladderCreator.create();
    }
}
