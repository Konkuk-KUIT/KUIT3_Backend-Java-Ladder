package ladder.exception;

public enum ExceptionMessage {
    INVALID_POSITION("유효하지 않은 위치입니다."),
    INVALID_PARTICIPANT_COUNT("참여자 수는 1명 이상이어야 합니다."),
    DUPLICATE_LINE("중복된 선을 그릴 수 없는 위치입니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
