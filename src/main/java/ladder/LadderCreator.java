package ladder;

import Numbers.NaturalNum;
import Numbers.Number;
import Numbers.Position;

public class LadderCreator {
    private Row[] rows;

    private LadderCreator(NaturalNum numberOfRows, NaturalNum numberOfPerson) {
        this.rows = new Row[numberOfRows.get()];
        for(int i = 0; i < numberOfRows.get(); i++) {
            this.rows[i] = new Row(numberOfPerson);
        }
    }
    public static LadderCreator of(NaturalNum numberOfRows, NaturalNum numberOfPerson){
        return new LadderCreator(numberOfRows, numberOfPerson);
    }

    public void DrawLine(Number row, Number col){
        this.rows[row.get()].drawLine(col);
    }

    public Row[] getrows(){
        return rows;
    }

}
