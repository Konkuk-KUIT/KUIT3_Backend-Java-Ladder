package ladder.game;

import ladder.model.LadderSize;
import ladder.creator.CustomLadderCreator;
import view.InputView;
import view.OutputView;

public class LadderGameFactory {
    public static LadderGame customLadderGame(LadderSize ladderSize) {
        CustomLadderCreator customLadderCreator = new CustomLadderCreator(ladderSize);
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        return new LadderGame(customLadderCreator,outputView,inputView);
    }
}
