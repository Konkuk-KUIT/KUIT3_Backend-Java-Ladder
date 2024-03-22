package ladder;

public class LadderCreator {
    private Row[] rows;

    //
    public LadderCreator(NaturalNumber naturalNumberOfRows, NaturalNumber naturalNumberOfPerson) {
        rows = new Row[naturalNumberOfRows.getNum()];
        for(int i = 0; i < naturalNumberOfRows.getNum(); i++) {
            rows[i] = new Row(naturalNumberOfPerson);
        }
    }


    public void drawLine(Position row, Position column) {
        rows[row.getValue()].drawLine(column);
    }


    public int numberOfLine(){
        return (int) (rows.length * rows[0].getLength() * 0.3);
    }

    public Row[] getRows(){
        return rows;
    }


}
