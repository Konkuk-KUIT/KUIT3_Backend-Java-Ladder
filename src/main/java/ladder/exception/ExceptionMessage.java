package ladder.exception;

public enum ExceptionMessage {
    INVALID_LADDER_POSITION("사다리 위치는 0이상의 정수입니다."),
    INVALID_LADDER_DRAWLINE("라인 생성이 불가능한 위치입니다."),
    INVALID_NUMBER_OF_PERSON("참여 인원은 1명 이상이어야 합니다.");

    //..

    private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
