package ladder;

public class Main {
    public static void main(String[] args) {
//        NaturalNumber numberOfRows = NaturalNumber.of(4);
//        NaturalNumber numberOfPersons = NaturalNumber.of(5);
//
//        LadderCreator ladderCreator = new LadderCreator(numberOfRows, numberOfPersons);
//
//        LadderGame ladderGame = new LadderGame(ladderCreator);
        LadderGame ladderGame = LadderGameFactory.createRandomLadderGame(5,5);
        Position startPosition = Position.of(0);
        Position endPosition = ladderGame.runGame(startPosition);
        System.out.println("Start Position: " + startPosition.getPosition() + " -> End Position: " + endPosition.getPosition());

    }
}
