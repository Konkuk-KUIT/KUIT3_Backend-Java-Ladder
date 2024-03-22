package exception;

public class LadderException extends RuntimeException {

  private final ErrorCode errorCode;

  public LadderException(ErrorCode errorCode) {
    super(errorCode.getMessage());
    this.errorCode = errorCode;
  }

  public ErrorCode getErrorCode() {
    return this.errorCode;
  }
}
