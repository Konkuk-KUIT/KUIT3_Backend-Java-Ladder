package ladder.application;

import ladder.core.Row;
import ladder.position.LadderPosition;
import ladder.position.Position;

public class LadderRunner {
    private Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(Position position) {
        for (int i = 0; i < rows.length; i++) {
            printLadder(LadderPosition.of(Position.of(i), position), "Before");
            position = rows[i].nextPosition(position);
            printLadder(LadderPosition.of(Position.of(i), position), "After");
        }
        return position.getPosition();
    }

    public String generate(LadderPosition currentPosition) {

        String totalLadder = new String();
        for (int i = 0; i < rows.length; i++) {
            totalLadder += rows[i].generateRow(Position.of(i), currentPosition);
        }
        return totalLadder;
    }

    public void printLadder(LadderPosition currentPosition, String state) {
        System.out.println(state);
        String ladder = generate(currentPosition);
        System.out.println(ladder);
    }
}
