package ladder;

public class LadderGame {
    private Ladder ladder;
    private LadderRunner ladderRunner;
    private String gameResult;

    public LadderGame(LadderCreator ladderCreator, NaturalNumber numberOfRows, NaturalNumber numberOfPerson) {
        ladder = ladderCreator.createLadder(numberOfRows, numberOfPerson);
        ladderRunner = new LadderRunner(ladder);
        gameResult = "";
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Position run(Position position) {
        return ladderRunner.run(position);
    }

    public void runAllPlayer() {
        gameResult = ladderRunner.runAllPlayer();
    }

    public String printLadder() {
        return ladder.printLadder();
    }

    public String printGameResult() {
        return gameResult;
    }
}
