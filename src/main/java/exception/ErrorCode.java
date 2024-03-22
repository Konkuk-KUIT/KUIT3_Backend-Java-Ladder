package exception;

public enum ErrorCode {

  // draw
  OUT_OF_BOUNDS_RAW_POSITION("라인 생성 중 row 범위를 초과했습니다."),
  OUT_OF_BOUNDS_COL_POSITION("라인 생성 중 col 범위를 초과했습니다."),
  DISALLOWED_CONTINUOUS_LINE("동일한 높이에 연속으로 라인을 생성할 수 없습니다."),
  LINE_ALREADY_EXISTS("이미 라인이 존재하는 위치입니다."),

  // game
  OUT_OF_BOUNDS_START_POSITION("시작 위치가 사다리 범위를 초과했습니다."),
  INVALID_NUMBER_OF_POSITION("포지션의 입력값은 1 이상이어야 합니다."),

  // create
  INVALID_NUMBER_OF_LADDER("사다리의 행과 열은 1 이상 1,000,000 이하의 자연수이어야 합니다.");

  private final String message;

  ErrorCode(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
