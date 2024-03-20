package ladder;

public class Ladder {
    private final LadderCreator ladderCreator;
    private final LadderRunner ladderRunner;

    public Ladder(NaturalNumber numberOfRows, NaturalNumber numberOfPerson) {
        ladderCreator = new LadderCreator(numberOfRows, numberOfPerson);
        ladderRunner = new LadderGame(ladderCreator).startGame();
    }

    public void drawLine(Position row, Position col) {
        ladderCreator.drawLine(row, col);
    }

    public Position run(Position position) {
        return ladderRunner.run(position);
    }
}
