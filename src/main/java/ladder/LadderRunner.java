package ladder;

import utils.Position;
import utils.Row;

public class LadderRunner {

  private final Row[] rows;

  private LadderRunner(Row[] rows) {
    this.rows = rows;
  }

  public static LadderRunner of(Row[] rows) {
    return new LadderRunner(rows);
  }

  public Position run(Position colP) {
    for (int i = 1; i < rows.length; i++) {
      colP = rows[i].getNextPosition(colP);
    }
    return colP;
  }
}
