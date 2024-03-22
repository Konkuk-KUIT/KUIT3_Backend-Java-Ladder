package ladder;

public final class LadderGame {
    private LadderFrame ladderFrame;
    public LadderGame(LadderFrame ladderFrame) {
        this.ladderFrame = ladderFrame;
    }

    public void drawLine(int row, int col) {
        LadderLineCreator ladderLineCreator = new LadderLineCreator(ladderFrame);
        ladderLineCreator.drawLine(row, col);
    }
    public Position playFrom(Position position) {
        LadderRunner ladderRunner = new LadderRunner(ladderFrame);
        return ladderRunner.runFrom(position);
    }
}