package model;

public enum ExceptionMessage {
    AT_LEAST_ONE("게임의 참여자 수는 1명 이상이어야 합니다."),
    IMPOSSIBLE_LOCATION_LINE("라인 생성이 불가능한 위치 입니다."),
    NOTVALIDATE_LOCATION("유효하지 않은 위치 입니다."),
    NOT_NATURAL_NUMBER("자연수가 아닙니다");

    private final String exceptionMessage;
    ExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }
    public String getExceptionMessage(){
        return exceptionMessage;
    }
}
