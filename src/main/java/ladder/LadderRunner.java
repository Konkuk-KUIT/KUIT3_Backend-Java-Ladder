package ladder;

public class LadderRunner {
    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public Position run(Position position) {
        for(int i = 0; i < rows.length; i++) {  // 사다리의 높이만큼 반복하는 거잖아
            position = rows[i].slide(position);
        }

        return position;
    }
}
