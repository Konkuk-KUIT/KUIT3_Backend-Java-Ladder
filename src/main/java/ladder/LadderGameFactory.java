package ladder;

import java.util.Random;
public class LadderGameFactory {
    public static LadderGame createRandomLadderGame(int numberOfRow, int numberOfPerson) {
        LadderCreator ladderCreator = new LadderCreator(NaturalNumber.of(numberOfRow), NaturalNumber.of(numberOfPerson));
        autoGenerateLines(ladderCreator, NaturalNumber.of(numberOfRow), NaturalNumber.of(numberOfPerson));
        return new LadderGame(ladderCreator);
    }
    private static void autoGenerateLines(LadderCreator ladderCreator, NaturalNumber numberOfRow, NaturalNumber numberOfPerson) {
        int lineCount = new LadderSize(numberOfRow, numberOfPerson).calculateLines();
        Random random = new Random();

        while (lineCount > 0) {
            int row = random.nextInt(numberOfRow.get());
            int col = random.nextInt(numberOfPerson.get() - 1);

            try {
                ladderCreator.drawLine(row, col);
                lineCount--;
            } catch (IllegalArgumentException e) {
            }
        }
    }
}
