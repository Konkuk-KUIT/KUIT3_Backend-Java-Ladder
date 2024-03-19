package ladder;

public class LadderCreator {
    private Row[] rows;

    private LadderCreator(int numberOfRows, int numberOfPerson) {
        this.rows = new Row[numberOfPerson];
        for(int i = 0; i < numberOfRows; i++) {
            this.rows[i] = new Row(numberOfPerson);
        }
    }
    public static LadderCreator of(int numberOfRows, int numberOfPerson){
        return new LadderCreator(numberOfRows, numberOfPerson);
    }

    public void DrawLine(int row,int col){
        this.rows[row].drawLine(col);
    }

    public Row[] getrows(){
        return rows;
    }

}
