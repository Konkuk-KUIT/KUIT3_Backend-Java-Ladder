package ladder;

import Numbers.Number;
import Numbers.Position;

public class LadderRunner {
    private LadderCreator laddercreator;
    private Row[] rows;

    private LadderRunner(Row[] Rows/*LadderCreator Creator*/){
        //laddercreator = Creator;
        this.rows=Rows;
    }
    public static LadderRunner of( Row[] Rows/*LadderCreator Creator*/){
        return new LadderRunner(Rows);
    }
    public Position run(Position position){
        //Row[] rows = rows.getrows();
        /*Position CurrentPosition;*/
        for(int i = 0; i < rows.length; i++) {
            position= rows[i].nextPosition(position);
        }

        return position;
    }

    public Position runAndPrint(Position position){
        for(int i = 0; i < rows.length; i++) {
            System.out.println("Before");
            printLadder(position,i);
            position= rows[i].nextPosition(position);
            System.out.println("After");
            printLadder(position,i);
        }
        return position;
    }

    public void printLadder(Position position,int col){
        String marker = "*";
        String target=null;
        for (int i =0 ;i< rows.length;i++) {
            if(i==col){
                rows[i].printRow(position,marker);
            }else{
                rows[i].printRow(null,null);
            }
        }
    }


}
