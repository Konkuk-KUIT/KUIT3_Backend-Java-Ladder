package ladder;

public enum ExeptionMessage {
    INVALID_NUMBER_OF_PERSON("게임의 참여자 수는 1명 이상이어야 합니다."),
    INVALID_LADDER_POSITION("라인 생성이 불가능한 위치 입니다."),
    INVALID_POSITION("유효하지 않은 위치 입니다."),
    NOT_NATURAL_NUMBER("자연수는 1이상의 정수입니다."),
    NOT_VALID_NUMBER("유효한 숫자가 아닙니다.");

    private final String message;
    ExeptionMessage(String message) {
        this.message = message;
    }
}
