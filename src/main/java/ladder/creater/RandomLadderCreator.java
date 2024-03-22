package ladder.creater;

import ladder.application.LadderSize;
import ladder.core.NaturalNumber;
import ladder.core.Row;
import ladder.position.LadderPosition;
import ladder.position.Position;

import java.util.HashSet;
import java.util.Random;

public class RandomLadderCreator {
    private final Row[] rows;
    private final LadderSize ladderSize;

    private final Random random = new Random();

    public RandomLadderCreator(LadderSize ladderSize) {
        this.ladderSize = ladderSize;
        rows = new Row[ladderSize.getHeight()];
        for(int i =0; i< ladderSize.getHeight(); i++){
            rows[i] = new Row(NaturalNumber.of(ladderSize.getWidth()));
        }
    }

    private void drawLines() {
        HashSet<Integer> checknum = new HashSet<>();
        for(int i =0; i<numberOfLine(); i++){
            int num = random.nextInt(0,ladderSize.getHeight() * ladderSize.getWidth() -1);
            checknum.add(num);

            Position row = Position.of(num / ladderSize.getWidth());
            Position col = Position.of(num % ladderSize.getWidth());

            drawLine(row, col);
        }
    }

    public void drawLine(Position row, Position col) {
        rows[row.getPosition()].drawLine(col);
    }

    private int numberOfLine() {
        return (int) (ladderSize.getWidth() * ladderSize.getHeight()* 0.3);
    }
}
