package ladder;

import utils.Position;

public class LadderGame {

  private final LadderCreator ladderCreator;
  private final LadderRunner ladderRunner;

  public LadderGame(LadderCreator ladderCreator) {
    this.ladderCreator = ladderCreator;
    this.ladderRunner = LadderRunner.of(ladderCreator.getRows());
  }

  public int run(Position colP) {
    return ladderRunner.run(colP).getIntValue();
  }
}
