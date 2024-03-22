package exception;

public enum ErrorCode {

  // draw
  OUT_OF_BOUNDS_RAW_POSITION("라인을 생성할 수 있는 열의 범위를 초과한 위치입니다."),
  OUT_OF_BOUNDS_COL_POSITION("라인을 생성할 수 있는 행의 범위를 초과한 위치입니다."),
  DISALLOWED_CONTINUOUS_LINE("동일한 높이에 연속으로 라인을 생성할 수 없습니다."),
  LINE_ALREADY_EXISTS("해당 위치에 이미 라인이 존재합니다."),

  // game
  OUT_OF_BOUNDS_START_POSITION("게임 시작 위치가 사다리 범위를 초과했습니다."),
  INVALID_NUMBER_OF_POSITION("위치 입력값은 1 이상의 자연수이어야 합니다."),

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
