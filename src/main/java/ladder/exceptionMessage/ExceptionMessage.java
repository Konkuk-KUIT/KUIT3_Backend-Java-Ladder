package ladder.exceptionMessage;

public enum ExceptionMessage {
    NUMBER_OF_PERSON("게임의 참여자 수는 1명 이상이어야 합니다."),
    DRAWSLINE_POSITION("라인 생성이 불가능한 위치 입니다."),
    POSITION("유효하지 않은 위치 입니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
