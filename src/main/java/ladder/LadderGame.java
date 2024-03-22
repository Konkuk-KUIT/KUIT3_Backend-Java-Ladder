package ladder;

import LadderCreator.LadderCreator;
import model.Position;

public class LadderGame {
    private final LadderCreator lc;

    public LadderGame(LadderCreator lc){
        this.lc = lc;
    }
    public Position run_game(Position position){
        LadderRunner ld = new LadderRunner(lc);
        return ld.run(position);
    }
}
