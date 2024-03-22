package ladder;

public class LadderGame {
    private final LadderCreator ladderCreator;

    public LadderGame(LadderCreator ladderCreator){
        this.ladderCreator = ladderCreator;
    }

    public Position run(Position position){
        LadderRunner ladderRunner =new LadderRunner(ladderCreator.getRows());
        return ladderRunner.run((position));
    }
}
