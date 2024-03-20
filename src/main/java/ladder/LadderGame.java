package ladder;

public class LadderGame {
    private Ladder ladder;

    public LadderGame(LadderCreator ladderCreator, NaturalNumber numberOfRows, NaturalNumber numberOfPerson) {
        ladder = ladderCreator.createLadder(numberOfRows, numberOfPerson);
    }

    public String printLadder() {
        return ladder.printLadder();
    }

    public String printGameResult() {
        return ladder.printGameResult();
    }
}
