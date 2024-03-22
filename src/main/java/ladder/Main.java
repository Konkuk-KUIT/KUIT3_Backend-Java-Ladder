package ladder;

public class Main {
    public static void main(String[] args) {
        NaturalNumber Row=NaturalNumber.of(4);
        NaturalNumber Person=NaturalNumber.of(4);
        Position startPosition=Position.of(1);

        LadderCreator ladderCreator = new LadderCreator(Row,Person);
        LadderGame ladderGame = new LadderGame(ladderCreator);
        ladderGame.run(startPosition);

    }
}
