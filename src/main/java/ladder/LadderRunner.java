package ladder;

public class LadderRunner {
    private Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(Position position) {

        for(int i = 0; i< rows.length; i++){
            System.out.println("LadderRunner.run"   );
            Position nextPosition = rows[i].nextPosition(position);
            System.out.println(rows[i].toString());
            position = nextPosition;
        }
        System.out.println();
        return position.getPosition();
    }
}
