package ladder;

import java.util.Random;

public class RandomLadderCreator implements LadderCreator {
    static Random random = new Random();

    @Override
    public Ladder createLadder(NaturalNumber numberOfRows, NaturalNumber numberOfPerson) {
        Ladder ladder = new Ladder(numberOfRows, numberOfPerson);
        int numberOfLines = (int) (numberOfRows.get() * numberOfPerson.get() * 0.3);

        // 시드 설정
        random.setSeed(System.currentTimeMillis());
        // 라인 임의 생성을 반복
        for (int i = 0; i < numberOfLines; i++) {
            makeRandomLine(ladder, numberOfRows, numberOfPerson);
        }

        return ladder;
    }

    private void makeRandomLine(Ladder ladder, NaturalNumber numberOfRows, NaturalNumber numberOfPerson) {
        int row = selectRandomRow(ladder, numberOfRows);
        int col = selectRandomColumn(ladder, numberOfPerson);

        while (true) {
            try {
                ladder.drawLine(row, col);
                break;
            } catch (IllegalArgumentException e) {
                row = selectRandomRow(ladder, numberOfRows);
                col = selectRandomColumn(ladder, numberOfPerson);
            }
        }
    }

    private int selectRandomRow(Ladder ladder, NaturalNumber numberOfRows) {
        return random.nextInt(numberOfRows.get());
    }

    private int selectRandomColumn(Ladder ladder, NaturalNumber numberOfPerson) {
        return random.nextInt(numberOfPerson.get());
    }
}
