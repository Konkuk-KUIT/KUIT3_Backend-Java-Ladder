package ladder;

public enum ExceptionMessage {
    INVALID_NUMBER_OF_PERSON("참여 인원은 1명 이상이어야 합니다."),
    INVALID_LINE_CREATE_POSITION("라인 생성이 불가능한 위치 입니다."),
    INVALID_POSITION("유효하지 않은 위치 입니다."),
    ERROR_IS_NOT_NATURAL_NUMBER("1 이상의 숫자여야 합니다.");
    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
