package ladder;

public class LadderGame {
    private LadderCreator ladderCreator;

    public LadderGame (LadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator;
    }
    public int run(Position position){
        LadderRun ladderRun = new LadderRun(ladderCreator.getRows());
        return ladderRun.run(position);

    }



}
