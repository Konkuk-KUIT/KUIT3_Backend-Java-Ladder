package ladder;

import Numbers.NaturalNum;
import Numbers.Number;
import Numbers.Position;

import java.util.Vector;

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

    public void DrawRandomLine(){
        int rowNum = rows.length;
        int colNum = rows[0].getRowSize();//.length;
        int LineCounter = (int)( rowNum * colNum * 0.33);

        System.out.printf("LineCounter : %d",LineCounter);

        Vector<Row> leftRow = new Vector<Row>();
        for(Row row : rows){
            leftRow.add(row);
        }

        while(LineCounter > 0 && leftRow.size()>0){
            int index = (int)(Math.random()* (leftRow.size()+1-1));
            if(leftRow.get(index).drawRandomLine()){
                LineCounter -- ;
            }else{
                leftRow.remove(index);
            }
            System.out.printf("loop:%d",LineCounter);

        }
        if(leftRow.size()==0&&LineCounter>0){
            throw new IllegalArgumentException("더 이상 랜덤 사다리를 그릴 수 없습니다.");
        }

    }

    public Row[] getrows(){
        return rows;
    }

}
