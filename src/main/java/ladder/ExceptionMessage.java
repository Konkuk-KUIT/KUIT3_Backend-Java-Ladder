package ladder;

public enum ExceptionMessage {
    INVALID_NUMBER_OF_PERSON("게임의 참여자 수는 1명 이상이어야 합니다."),
    INVALID_DRAW_LINE_POSITION("게임의 참여자 수는 1명 이사이어야 합니다."),
    INVALID_POSITION("유효하지 않는 위치 입니다.");

    private final String errorMessage;

    ExceptionMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
