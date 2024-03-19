package ladder.game;

import ladder.model.Position;
import ladder.creator.LadderCreator;
import view.InputView;
import view.OutputView;

public class LadderGame {
    private final LadderCreator ladderCreator;
    private final OutputView outputView;
    private final InputView inputView;
    public LadderGame(LadderCreator ladderCreator,OutputView outputView, InputView inputView){
        this.ladderCreator = ladderCreator;
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void play(int number){
        drawLines();
        Position position = new Position(number);
        int destination = runLadder(position);
        printDestination(destination);

    }

    private int runLadder(Position number) {
        LadderRunner ladderRunner = new LadderRunner(ladderCreator.getRows());
        return ladderRunner.run(number);
    }

    private void drawLines() {
        // 이것도 변경 필요성 있음
        ladderCreator.drawLine();
    }

    private void printDestination(int destination) {
        outputView.printDestination(destination);
    }
}
