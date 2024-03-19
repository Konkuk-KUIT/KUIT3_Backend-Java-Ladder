package ladder;

public class LadderRunner {
    private Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public Position run(Position startPosition) {
        Position currentPositionX = startPosition;
        LadderPosition currentPosition = LadderPosition.of(currentPositionX.getPosition(), 0);

        for (int i = 0; i < rows.length; i++) {

            System.out.println();
            System.out.println("Before");
            printLadderWithStar(currentPosition);

            int newPosition = rows[i].nextPosition(currentPositionX.getPosition());
            currentPositionX = Position.of(newPosition);
            currentPosition = LadderPosition.of(currentPositionX.getPosition(), i);

            System.out.println();
            System.out.println("After");
            printLadderWithStar(currentPosition);

            currentPosition = LadderPosition.of(currentPositionX.getPosition(), i+1);
        }

        return currentPositionX;
    }
    public void printLadderWithStar(LadderPosition starPosition) {
        for (int y = 0; y < rows.length; y++) {
            StringBuilder sb = new StringBuilder();
            String rowState = rows[y].toString(starPosition,y);
            sb.append(rowState);

            System.out.println(sb.toString().trim());
        }
    }
}
