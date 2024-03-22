package ladder;

public final class LadderLineCreator {
    private LadderFrame ladderFrame;
    public LadderLineCreator(LadderFrame ladderFrame){
        this.ladderFrame = ladderFrame;
    }
    public void drawLine(int row, int col) {
        ladderFrame.getRowOfIndex(row).drawLine(Position.at(col));
    }
}
