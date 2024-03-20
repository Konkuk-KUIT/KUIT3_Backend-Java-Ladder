package ladder;

public class Ladder {
    private Row[] rows;

    public Ladder(NaturalNumber numberOfRows, NaturalNumber numberOfPerson) {
        rows = new Row[numberOfRows.get()];

        for (int i = 0; i < numberOfRows.get(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    public void drawLine(int row, int col) {
        rows[row].drawLine(col);
    }

    public int run(int position) {
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
        int nthPerson = 0;

        while (true) {
            try {
                String nthPersonResult = String.valueOf(nthPerson) +
                        " : " +
                        String.valueOf(run(nthPerson++)) +
                        " | ";
                gameResult.append(nthPersonResult);
            } catch (IllegalArgumentException e) {
                break;
            }
        }
        return gameResult.toString();
    }
}
