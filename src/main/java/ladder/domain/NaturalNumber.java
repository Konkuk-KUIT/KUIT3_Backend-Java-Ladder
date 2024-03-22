package ladder.domain;

import ladder.exception.ExceptionMessage;

public class NaturalNumber {
    private final int num;


    public static NaturalNumber of(int num){
        return new NaturalNumber(num);
    }

    private NaturalNumber(int num){
        validate(num);
        this.num = num;
    }

    public void validate(int num){
        if(num < 1) throw new IllegalArgumentException(ExceptionMessage.INVALID_PERSON_NUM.getMessage());
    }

    public int get(){
        return this.num;
    }
}
