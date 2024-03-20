import ladder.game.LadderGame;
import ladder.game.LadderGameFactory;
import ladder.model.LadderSize;

public class LadderApplication {
    public static void main(String[] args) {
        LadderSize ladderSize = new LadderSize(3,3);
        LadderGame ladderGame = LadderGameFactory.randomLadderGame(ladderSize);
        ladderGame.play(1);
    }
}
