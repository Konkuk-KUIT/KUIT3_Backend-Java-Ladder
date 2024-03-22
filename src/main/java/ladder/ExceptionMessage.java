package ladder;

public enum ExceptionMessage {
    INVALID_NATURAL_NUMBER("자연수가 아닙니다."),
    INVALID_LINE_POSITION("라인 생성이 불가능한 위치 입니다."),
    INVALID_POSITION("유효하지 않은 위치 입니다."),
    INVALID_NUMBER_OF_PERSON("게임의 참여자 수는 1명 이상이어야 합니다.");


    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

}
