package ladder;

public enum ExceptionMessage {

    INVALID_LADDER_POSITION("게임의 참여자 수는 1명 이상이어야 합니다."),
    INVALID_DRAW_POSITION("라인 생성이 불가능한 위치입니다."),
    INVALID_POSITION("유효하지 않은 위치입니다."),
    INVALID_NUMBER("유효하지 않은 숫자입니다.");

    private final String message;


    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
