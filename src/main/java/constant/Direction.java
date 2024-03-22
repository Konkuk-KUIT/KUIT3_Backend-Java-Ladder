package constant;

public enum Direction {

  RIGHT(1), LEFT(-1), NONE_DIRECTION(0);

  private final int value;

  Direction(int value) {
    this.value = value;
  }

  public int getIntValue() {
    return this.value;
  }
}
