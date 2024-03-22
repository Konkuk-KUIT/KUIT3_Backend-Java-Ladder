package ladder.game;

import ladder.domain.NaturalNumber;
import ladder.domain.Position;
import ladder.domain.Row;

public class LadderCreator {
    private Row[] rows;
    public LadderCreator(NaturalNumber numberOfRows, NaturalNumber numberOfPerson){
        rows = new Row[numberOfPerson.get()];

        for(int i = 0; i < numberOfRows.get(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }
    public void drawLine(Position row, Position col) {
        rows[row.get()].drawLine(col);
    }

    public Row[] getRows(){
        return rows;
        // row를 복사해서 반환
    }
}
