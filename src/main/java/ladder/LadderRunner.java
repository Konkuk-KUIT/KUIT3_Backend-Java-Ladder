package ladder;

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
    public int run(int position){
        //Row[] rows = rows.getrows();
        for(int i = 0; i < rows.length; i++) {
            position = rows[i].nextPosition(position);
        }
        return position;
    }

}
