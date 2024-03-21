package ladder;

public class LadderRunner {
    private Row[] rows;

    public LadderRunner(Ladder ladder) {
        this.rows = ladder.getRows();
    }

    public Position run(Position position) {
        for (Row row : rows) {
            position = row.move(position);
        }

        return position;
    }

    public void runAllPlayer(LadderGameResultPrinter ladderGameResultPrinter) {
        StringBuilder gameResult = new StringBuilder();
        Position nthPerson = Position.of(0, NaturalNumber.of(rows[0].size()));

        while (true) {
            try {
                // 한 사람 게임 진행 및 해당 결과 임시 기록
                String nthPersonResult = nthPerson.get() + " : " + run(nthPerson).get() + " | ";
                gameResult.append(nthPersonResult);

                // 다음 사람으로 변경
                nthPerson = nthPerson.next();
            } catch (IllegalArgumentException e) {
                break;
            }
        }
        // 임시 기록을 실제 기록으로 전환
        ladderGameResultPrinter.write(gameResult.toString());
    }
}
