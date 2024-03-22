package ladder.exception;

public enum ExceptionMessage {

    INVALID_LADDER_POSITION("유효하지 않은 위치입니다."),
    INVALID_NUMBER_OF_PERSON("참여 인원은 2명 이상이어야 합니다."),
    INVALID_ROW_POSITION("라인 생성이 불가능한 위치입니다."),
    INVALID_NATURAL_NUMBER("1 이상의 정수여야 합니다.");

    //..

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}