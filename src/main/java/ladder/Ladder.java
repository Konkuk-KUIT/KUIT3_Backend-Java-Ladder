package ladder;

public class Ladder {

    private Row[] rows;
    private LadderCreator laddercreator;
    private LadderRunner ladderrunner;

    public Ladder(int numberOfRows, int numberOfPerson) {
        NaturalNum Rows;
        NaturalNum Person;
        try {
            Rows = NaturalNum.of(numberOfRows);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("행의 개수는 1개 이상이어야 합니다.");
        }

        try{
            Person = NaturalNum.of(numberOfPerson);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("게임의 참여자는 1명 이상이어야 합니다.");
        }

        laddercreator = LadderCreator.of(Rows,Person);
    }

    public void drawLine(int row, int col) {
        laddercreator.DrawLine(row,col);//NaturalNum.of(row),NaturalNum.of(col));
    }

    public int run(int position) {
        ladderrunner = LadderRunner.of(laddercreator.getrows());
        return ladderrunner.run(position);
    }
}
