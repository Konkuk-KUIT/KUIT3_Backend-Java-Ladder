package ladder;

import ladder.ladderCreator.LadderCreator;

public class LadderRunner {
    private final Row[] rows;

    public LadderRunner(LadderCreator ladderCreator) {
        this.rows = ladderCreator.create();
    }

    public Position run(Position position) {
        for(int i = 0; i < rows.length; i++) {  // 사다리의 높이만큼 반복하는 거잖아
            position = rows[position.get()].slide(position);
        }

        return position;
    }
}
