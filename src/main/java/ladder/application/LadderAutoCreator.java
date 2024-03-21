package ladder.application;

import ladder.model.LadderSize;
import ladder.model.NaturalNumber;
import ladder.model.Row;

import java.util.Random;

public class LadderAutoCreator implements LadderCreatorInterface {
    private Row[] rows;


    public LadderAutoCreator(NaturalNumber numberOfRow, NaturalNumber numberOfPerson) {
        rows = new Row[numberOfRow.get()];
        for (int i = 0; i < numberOfRow.get(); i++) {
            rows[i] = new Row(numberOfPerson.get());
        }
        autoGenerateLines(this, numberOfRow, numberOfPerson);
    }

    private static void autoGenerateLines(LadderAutoCreator LadderAutoCreator, NaturalNumber numberOfRow, NaturalNumber numberOfPerson) {
        int lineCount = new LadderSize(numberOfRow, numberOfPerson).calculateLines();
        Random random = new Random();

        while (lineCount > 0) {
            int row = random.nextInt(numberOfRow.get());
            int col = random.nextInt(numberOfPerson.get() - 1);

            try {
                LadderAutoCreator.drawLine(row, col);
                lineCount--;
            } catch (IllegalArgumentException e) {
            }
        }
    }

    public void drawLine(int row, int col) {
        rows[row].drawLine(col);
    }

    public Row[] getRows() {
        return rows;
    }

}