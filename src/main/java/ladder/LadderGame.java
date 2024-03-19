package ladder;

public class LadderGame {
    private final LadderCreatorInterface ladderCreator;

    public LadderGame(LadderCreatorInterface ladderCreator) {
        this.ladderCreator = ladderCreator;
    }

    public Position runGame(Position startPosition) {
        LadderRunner runner = new LadderRunner(ladderCreator.getRows());
        return runner.run(startPosition);
    }
}