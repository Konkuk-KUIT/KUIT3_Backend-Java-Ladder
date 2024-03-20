package ladder;

import ladder.ladderCreator.LadderCreator;

public class LadderGame {

    private final LadderCreator ladderCreator;
    private final LadderRunner ladderRunner;

    public LadderGame(LadderCreator ladderCreator, LadderRunner ladderRunner) {
        this.ladderCreator = ladderCreator;
        this.ladderRunner = ladderRunner;
    }

    public void play() {
        ladderCreator.create();
        ladderRunner.run(new Position ());  // 임시값
    }

    private void createLadder() {
        ladderCreator.create();
    }
}
