package ladder;

public enum ExceptionMessage {
    BAD_PERSON_NUMBER("참여자 수는 2명 이상입니다.");


    private String message;

    ExceptionMessage(String msg){
        this.message = msg;
    }

}
