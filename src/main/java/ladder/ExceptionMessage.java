package ladder;

public enum ExceptionMessage {
    INVALID_LADDER_POSITION("유효하지 않은 위치입니다."),
    INVALID_LINE_START_POSITION("라인 생성이 불가능한 위치입니다."),
    INVALID_NUMBER_OF_PERSON("참여 인원은 1명 이상이어야 합니다."),
    INVALID_NATURAL_NUMBER("자연수는 1 이상의 정수이어야 합니다.");

    private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}
