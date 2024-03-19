package ladder;

import java.util.Random;

public class RandomLadderCreator implements LadderCreator {
    static Random random = new Random();

    @Override
    public Ladder createLadder(int numberOfRows, int numberOfPerson) {
        Ladder ladder = new Ladder(numberOfRows, numberOfPerson);
        int numberOfLines = (int) (numberOfRows * numberOfPerson * 0.3);

        // 시드 설정
        random.setSeed(System.currentTimeMillis());
        // 라인 임의 생성을 반복
        for (int i = 0; i < numberOfLines; i++) {
            makeRandomLine(ladder, numberOfRows, numberOfPerson);
        }

        return ladder;
    }

    private void makeRandomLine(Ladder ladder, int numberOfRows, int numberOfPerson) {
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

    private int selectRandomRow(Ladder ladder, int numberOfRows) {
        return random.nextInt(numberOfRows);
    }

    private int selectRandomColumn(Ladder ladder, int numberOfPerson) {
        return random.nextInt(numberOfPerson);
    }
}
