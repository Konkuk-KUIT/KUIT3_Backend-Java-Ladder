package ladder;

import static exception.ErrorCode.OUT_OF_BOUNDS_RAW_POSITION;

import exception.LadderException;
import utils.LadderNumber;
import utils.Position;
import utils.Row;

public class LadderCreator {

  private final Row[] rows;

  private LadderCreator(LadderNumber numberOfRows, LadderNumber numberOfPerson) {
    rows = new Row[numberOfRows.getIntValue() + 1];
    for (int i = 1; i <= numberOfRows.getIntValue(); i++) {
      rows[i] = Row.of(numberOfPerson);
    }
  }

  public static LadderCreator of(LadderNumber numberOfRows, LadderNumber numberOfPerson) {
    return new LadderCreator(numberOfRows, numberOfPerson);
  }

  public void drawLine(Position rowP, Position colP) {
    validateRowPosition(rowP);
    rows[rowP.getIntValue()].drawLine(colP);
  }

  private void validateRowPosition(Position rowP) {
    if (rowP.getIntValue() >= rows.length) {
      throw new LadderException(OUT_OF_BOUNDS_RAW_POSITION);
    }
  }
  public Row[] getRows() {
    return this.rows;
  }
}
