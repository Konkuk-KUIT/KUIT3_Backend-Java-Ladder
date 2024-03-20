package ladder;

public class LadderGame {
    private final LadderCreator ladderCreator;

    public LadderGame(LadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator;
    }
    public LadderRunner startGame(){
        return new LadderRunner(ladderCreator.getRows());
    }
}
