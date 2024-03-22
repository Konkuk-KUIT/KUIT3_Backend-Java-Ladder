package ladder;

import static exception.ErrorCode.OUT_OF_BOUNDS_START_POSITION;

import exception.LadderException;
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
    validateStartPosition(colP);
    for (int i = 1; i < rows.length; i++) {
      colP = rows[i].getNextPosition(colP);
    }
    return colP;
  }

  private void validateStartPosition(Position colP) {
    if (colP.getIntValue() > getColSize()) {
      throw new LadderException(OUT_OF_BOUNDS_START_POSITION);
    }
  }

  private int getColSize() {
    return rows[1].getNodes().length - 1;
  }
}
