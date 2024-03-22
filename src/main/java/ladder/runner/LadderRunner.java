package ladder.runner;

import ladder.data.LadderPosition;
import ladder.data.Row;
import type.Position;

public class LadderRunner {

    Row[] rows;
    LadderPosition ladderPosition;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(Position position) {
        ladderPosition = new LadderPosition(position.getPosition(), 0);
        for(Row row : rows) {
            System.out.println("Before");
            print();
            position = row.nextPosition(position);
            ladderPosition.movePosition(position.getPosition() - ladderPosition.getXPosition(), 0);

            System.out.println("After");
            print();
            ladderPosition.movePosition(0, 1);
        }

        return position.getPosition();
    }

    public void print() {
        int i = 0;
        for(Row row : rows) {
            if(ladderPosition.getYPosition() == i)
                row.print(new Position(ladderPosition.getXPosition()));
            else
                row.print(null);
            System.out.println();
            i++;
        }
        System.out.println();
    }

}
