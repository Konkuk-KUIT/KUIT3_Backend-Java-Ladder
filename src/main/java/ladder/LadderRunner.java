package ladder;

import ladder.wrapper.Coordinate;
import ladder.wrapper.Position;
import ladder.wrapper.Row;

public class LadderRunner {
    private final Row[] rows;
    private final LadderPrinter ladderPrinter;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
        this.ladderPrinter = new LadderPrinter(rows);
    }

    public Position run(Position position) {
        for(int rowIndex = 0; rowIndex < rows.length; rowIndex++) {  // 사다리의 높이만큼 반복하는 거잖아
            ladderPrinter.print(Coordinate.ofIntPosition(rowIndex, position));
            position = rows[rowIndex].slide(position);
            ladderPrinter.print(Coordinate.ofIntPosition(rowIndex, position));
        }

        return position;
    }
}
