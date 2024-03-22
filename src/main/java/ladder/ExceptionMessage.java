package ladder;

public enum ExceptionMessage {
    INVAILD_LADDER_DRAW_POSITION("라인 생성이 불가능한 위치 입니다."),
    INVAILD_LADDER_POSITION("유효하지 않은 위치 입니다."),
    INVAILD_NUMBER_OF_PERSONS("게임의 참여자 수는 1명 이상이어야 합니다.");

    private final String exceptionString;

    ExceptionMessage (String exceptionString){
        this.exceptionString = exceptionString;
    }

    public String getValue(){
        return this.exceptionString;
    }

}
