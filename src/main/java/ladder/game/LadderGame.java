package ladder.game;

import ladder.domain.Position;

public class LadderGame {
    private LadderCreator ladderCreator;
    public LadderGame(LadderCreator ladderCreator){
        this.ladderCreator = ladderCreator;
    }

    public Position playGame(Position position){
        LadderRunner ladderRunner = new LadderRunner(ladderCreator);
        return ladderRunner.run(position);
    }
}
