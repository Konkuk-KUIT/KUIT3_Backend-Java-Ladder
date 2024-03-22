package ladder;

public final class LadderRunner {
    private LadderFrame ladderFrame;
    public LadderRunner(LadderFrame ladderFrame){
        this.ladderFrame = ladderFrame;
    }
    public Position runFrom(Position position) {
        for(int i = 0; i < ladderFrame.getRowsLength(); i++) {
            position = ladderFrame.getRowOfIndex(i).nextPosition(position);
        }
        return position;
    }
}
