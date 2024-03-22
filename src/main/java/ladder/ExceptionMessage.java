package ladder;

public enum ExceptionMessage {

    INVALID_LADDER_POSITION("사다리 위치는 0이상의 정수입니다."),
    INVALID_NUMBER_OF_PERSON("참여 인원은 2명 이상이어야 합니다."),

    INVALID_NUMBER_OF_ROW("사다리의 높이는 1칸 이상이어야 합니다."),
    INVALID_POSITION("유효하지 않은 위치 입니다."),

    INVALID_POISTION_START("유효하지 않은 시작 위치 입니다.");

    //..

    private String message;


    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getExceptionMessage(){
        return message;
    }
}
