package ladder;

public class Ladder {
    private Row[] rows;

    public Ladder(NaturalNumber numberOfRows, NaturalNumber numberOfPerson) {
        rows = new Row[numberOfRows.get()];

        for (int i = 0; i < numberOfRows.get(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    public void drawLine(Position row, Position col) {
        rows[row.get()].drawLine(col);
    }

    public Position run(Position position) {
        for (Row row : rows) {
            position = row.nextPosition(position);
        }

        return position;
    }

    public String printLadder() {
        StringBuilder ladderResult = new StringBuilder();
        for (Row row : rows) {
            ladderResult.append(row.printRow());
        }
        return ladderResult.toString();
    }

    public String printGameResult() {
        StringBuilder gameResult = new StringBuilder();
        Position nthPerson = Position.of(0, NaturalNumber.of(rows[0].size()));

        while (true) {
            try {
                // 한 사람 게임 진행
                String nthPersonResult = nthPerson.get() + " : " + run(nthPerson).get() + " | ";
                gameResult.append(nthPersonResult);

                // 다음 사람으로 변경
                nthPerson = nthPerson.next();
            } catch (IllegalArgumentException e) {
                break;
            }
        }
        return gameResult.toString();
    }
}
