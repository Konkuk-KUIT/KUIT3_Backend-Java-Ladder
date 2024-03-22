package utils;

import static exception.ErrorCode.INVALID_NUMBER_OF_POSITION;

import exception.LadderException;

public class Position {

  private int position;

  private static final int MIN_POSITION = 1;

  private Position(int position) {
    this.position = position;
  }

  public Position prev() {
    return Position.of(position - 1);
  }

  public Position next() {
    return Position.of(position + 1);
  }

  private static void validatePosition(int position) {
    if (position < MIN_POSITION) {
      throw new LadderException(INVALID_NUMBER_OF_POSITION);
    }
  }

  public static Position of(int position) {
    validatePosition(position);
    return new Position(position);
  }

  public int getIntValue() {
    return this.position;
  }
}
