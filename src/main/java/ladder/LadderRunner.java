package ladder;

import LadderCreator.LadderCreator;
import model.LadderPosition;
import model.Position;

public class LadderRunner {

    private final LadderCreator lc;

    public LadderRunner(LadderCreator lc) {
        this.lc = lc;
    }



    public Position run(Position position) {

        for(int i = 0; i < lc.getRows().length; i++) {
            System.out.println(lc.createStringLadder(LadderPosition.of(position,Position.of(i))));
            position = lc.getRows()[i].nextPosition(position);
            System.out.println(lc.createStringLadder(LadderPosition.of(position,Position.of(i))));
        }

        return position;
    }
}
