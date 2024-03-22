package ladder;

import static exception.ErrorCode.OUT_OF_BOUNDS_RAW_POSITION;

import exception.LadderException;
import utils.LadderSize;
import utils.Position;
import utils.Row;

public class LadderCreator {

  private final Row[] rows;
  private final LadderSize ladderSize;

  private LadderCreator(LadderSize ladderSize) {
    this.ladderSize = ladderSize;
    rows = new Row[ladderSize.getRowSize().getIntValue() + 1];
    for (int i = 1; i < rows.length; i++) {
      rows[i] = Row.of(ladderSize.getColSize());
    }
  }

  public static LadderCreator of(LadderSize ladderSize) {
    return new LadderCreator(ladderSize);
  }

  public void drawLine(Position rowP, Position colP) {
    validateRowPosition(rowP);
    rows[rowP.getIntValue()].drawLine(colP);
  }

  private void validateRowPosition(Position rowP) {
    if (!isWithinLadderBounds(rowP)) {
      throw new LadderException(OUT_OF_BOUNDS_RAW_POSITION);
    }
  }

  private boolean isWithinLadderBounds(Position rowP) {
    return rowP.getIntValue() <= ladderSize.getRowSize().getIntValue();
  }

  public Row[] getRows() {
    return this.rows;
  }
}
