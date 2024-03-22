package ladder;

import utils.Position;

public class LadderGame {

  private final LadderCreator ladderCreator;
  private final LadderRunner ladderRunner;

  private LadderGame(LadderCreator ladderCreator) {
    this.ladderCreator = ladderCreator;
    this.ladderRunner = LadderRunner.of(ladderCreator.getRows());
  }

  public static LadderGame of(LadderCreator ladderCreator) {
    return new LadderGame(ladderCreator);
  }

  public int run(Position colP) {
    return ladderRunner.run(colP).getIntValue();
  }
}
