package utils;

public class LadderSize {

  private final LadderNumber rowSize;
  private final LadderNumber colSize;

  private LadderSize(LadderNumber rowSize, LadderNumber colSize) {
    this.rowSize = rowSize;
    this.colSize = colSize;
  }

  public static LadderSize of(LadderNumber height, LadderNumber numberOfPerson) {
    return new LadderSize(height, numberOfPerson);
  }

  public LadderNumber getRowSize() {
    return rowSize;
  }

  public LadderNumber getColSize() {
    return colSize;
  }
}
