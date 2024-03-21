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

    public Position run(Position position) {
        return ladderRunner.run(position);
    }

    public void runAllPlayer() {
        ladderRunner.runAllPlayer(ladderGameResultPrinter);
    }

    // printRow 와는 달리, 사다리 게임을 진행하면서 Ladder 를 확인하고 싶을 수도 있기 때문에 생성
    public String printLadder() {
        return ladder.printLadder();
    }

    public String printGameResult() {
        return ladderGameResultPrinter.print();
    }
}
