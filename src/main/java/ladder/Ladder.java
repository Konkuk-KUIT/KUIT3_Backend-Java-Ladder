package ladder;

public class Ladder {

    private Row[] rows;
    private LadderCreator laddercreator;
    private LadderRunner ladderrunner;

    public Ladder(int numberOfRows, int numberOfPerson) {
        laddercreator = LadderCreator.of(numberOfRows,numberOfPerson);
    }

    public void drawLine(int row, int col) {
        laddercreator.DrawLine(row,col);
    }

    public int run(int position) {
        ladderrunner = LadderRunner.of(laddercreator.getrows());
        return ladderrunner.run(position);
    }
}
