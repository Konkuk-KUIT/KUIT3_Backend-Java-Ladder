package utils;

import static exception.ErrorCode.INVALID_NUMBER_OF_LADDER;

import exception.LadderException;

public class LadderNumber {

  private final int number;

  private final static int MIN_VALUE = 1;
  private final static int MAX_VALUE = 1_000_000;

  private LadderNumber(int number) {
    validateNumber(number);
    this.number = number;
  }

  private void validateNumber(int number) {
    if (number < MIN_VALUE || number > MAX_VALUE) {
      throw new LadderException(INVALID_NUMBER_OF_LADDER);
    }
  }

  public static LadderNumber of(int number) {
    return new LadderNumber(number);
  }

  public int getIntValue() {
    return this.number;
  }
}
