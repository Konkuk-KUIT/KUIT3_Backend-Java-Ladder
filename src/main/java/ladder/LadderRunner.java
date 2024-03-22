package ladder;

public class LadderRunner {
    private final Row[] rows;
    private final LadderPrinter ladderPrinter;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
        this.ladderPrinter = new LadderPrinter(rows);
    }

    public Position run(Position position) {
        for(int i = 0; i < rows.length; i++) {  // 사다리의 높이만큼 반복하는 거잖아
            ladderPrinter.print(i, position);
            position = rows[i].slide(position);
            ladderPrinter.print(i, position);
        }

        return position;
    }
}
