package ladder.game;

import ladder.Ladder;
import ladder.wrapper.NaturalNumber;
import ladder.wrapper.Position;
import ladder.creator.LadderCreator;
import ladder.printer.LadderGameResultPrinter;

public class LadderGame {
    private Ladder ladder;
    private LadderRunner ladderRunner;
    private LadderGameResultPrinter ladderGameResultPrinter;

    public LadderGame(LadderCreator ladderCreator, NaturalNumber numberOfRows, NaturalNumber numberOfPerson) {
        ladder = ladderCreator.createLadder(numberOfRows, numberOfPerson);
        ladderRunner = new LadderRunner(ladder);
        ladderGameResultPrinter = new LadderGameResultPrinter();
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Position run(Position position) {
        return ladderRunner.run(position);
    }

    public void runAllPlayer() {
        ladderRunner.runAllPlayer(ladderGameResultPrinter);
    }

    public String printLadder() {
        return ladder.printLadder();
    }

    public String printGameResult() {
        return ladderGameResultPrinter.print();
    }
}
