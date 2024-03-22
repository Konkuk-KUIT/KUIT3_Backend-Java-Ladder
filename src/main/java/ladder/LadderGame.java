package ladder;

import static ladder.ExceptionMessage.*;

public class LadderGame {

    private final LadderCreator ladderCreator;

    public LadderGame(LadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator;
    }

    public int run(Position position) {

        LadderRunner ladderRunner = new LadderRunner(ladderCreator.getRows());
        return ladderRunner.run(position);

    }
    public void printLadder(int startRow, int startPosition) {

        // base condition
        if (startRow >= ladderCreator.getIntOfRow()) {
            return;
        }

        isValidateLadder(startRow, startPosition);

        String[][] ladder = new String[ladderCreator.getIntOfRow()][];
        for (int i = 0; i < ladderCreator.getIntOfRow(); i++) {
            ladder[i] = ladderCreator.getRows()[i].getRowToString();
        }

        System.out.println("Before");
        printStrings(ladder, startRow, startPosition);

        if (ladder[startRow][startPosition].equals("1")) startPosition++;
        else if (ladder[startRow][startPosition].equals("-1")) startPosition--;

        System.out.println("After");
        printStrings(ladder, startRow, startPosition);

        printLadder(startRow + 1,startPosition);
    }


    private static void printStrings(String[][] ladder, int currentRow, int position) {
        for (int i = 0; i < ladder.length; i++) {
            for (int j = 0; j < ladder[i].length; j++) {
                if (i == currentRow && j == position) {
                    System.out.printf("%3s*", ladder[i][j]);
                } else {
                    System.out.printf("%3s ", ladder[i][j]);
                }
            }
            System.out.println();
        }
    }

    private void isValidateLadder(int row, int position) {
        // row 검증
        if (row < 0 || row >= ladderCreator.getIntOfRow()) {
            throw new IllegalArgumentException(INVALID_NUMBER.getMessage());
        }
        if (position < 0 || position >= ladderCreator.getIntOfPerson()) {
            throw new IllegalArgumentException(INVALID_NUMBER.getMessage());
        }
    }
}
