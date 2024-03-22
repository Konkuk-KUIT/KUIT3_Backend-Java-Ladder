import ladder.game.LadderGame;
import ladder.game.LadderGameFactory;
import type.NaturalNumber;
import type.Position;

public class Main {

    public static void main(String[] args) {
        LadderGame ladderGame = LadderGameFactory.createRandomLadderGame(new NaturalNumber(4), new NaturalNumber(3));
        ladderGame.play(new Position(0));
    }

}
