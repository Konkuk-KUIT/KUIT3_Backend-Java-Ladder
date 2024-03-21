package ladder.view;

import ladder.application.LadderGame;
import ladder.application.LadderGameFactory;
import ladder.model.Position;

import static ladder.application.LadderGameFactory.CreatorType.AUTO;
import static ladder.application.LadderGameFactory.CreatorType.REGULAR;

public class Main {
    public static void main(String[] args) {
//        NaturalNumber numberOfRows = NaturalNumber.of(4);
//        NaturalNumber numberOfPersons = NaturalNumber.of(5);
//
//        LadderCreator ladderCreator = new LadderCreator(numberOfRows, numberOfPersons);
//
//        LadderGame ladderGame = new LadderGame(ladderCreator);
        LadderGame ladderGame = LadderGameFactory.createLadderGame(5,5,AUTO);
        Position startPosition = Position.of(0);
        Position endPosition = ladderGame.runGame(startPosition);
        System.out.println("Start Position: " + startPosition.getPosition() + " -> End Position: " + endPosition.getPosition());

    }
}
