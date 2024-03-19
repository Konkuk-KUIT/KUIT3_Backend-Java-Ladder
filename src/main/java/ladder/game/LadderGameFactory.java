package ladder.game;

import ladder.creator.RandomLadderCreator;
import ladder.model.LadderSize;
import ladder.creator.CustomLadderCreator;
import ladder.model.Row;
import view.InputView;
import view.OutputView;

public class LadderGameFactory {
    public static LadderGame customLadderGame(LadderSize ladderSize) {
        CustomLadderCreator customLadderCreator = new CustomLadderCreator(ladderSize);
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        return new LadderGame(customLadderCreator,outputView,inputView);
    }

    public static LadderGame randomLadderGame(LadderSize ladderSize) {
        RandomLadderCreator randomLadderCreator = new RandomLadderCreator(ladderSize);
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        return new LadderGame(randomLadderCreator,outputView,inputView);
    }
}
