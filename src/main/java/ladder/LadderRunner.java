package ladder;

public class LadderRunner {
    Row[] rows;
    public LadderRunner(Row[] rows){
        this.rows = rows;
    }

    public int run(Position position) {

        for(int i = 0; i < rows.length; i++) {
            position = rows[i].nextPosition(position);
        }

        return position.getPosition();
    }
}
