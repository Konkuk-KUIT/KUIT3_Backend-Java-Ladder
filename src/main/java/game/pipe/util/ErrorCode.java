package game.pipe.util;

public enum ErrorCode {
    LACK_PARTICIPANTS("게임의 참여자 수는 1명 이상이어야 합니다."),
    INVALID_LINE_POSITION("라인 생성이 불가능한 위치 입니다."),
    INVALID_POSITION("유효하지 않은 위치 입니다.")
    ;
    private final String message;

    ErrorCode(String errorMessage) {
        this.message = errorMessage;
    }

    public String getMessage() {
        return message;
    }
}
