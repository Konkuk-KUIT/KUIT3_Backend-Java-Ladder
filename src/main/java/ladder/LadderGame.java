package ladder;

public class LadderGame {
    private final LadderCreator ladderCreator;

    //DI로 필드 초기화
    public LadderGame(LadderCreator ladderCreator){
        this.ladderCreator = ladderCreator;
    }

    public int run(Position position){
        LadderRunner ladderRunner = new LadderRunner(ladderCreator);
        return ladderRunner.run(position);
    }
}
