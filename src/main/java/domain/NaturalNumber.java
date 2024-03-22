package domain;

import exception.ExceptionMessage;

public class NaturalNumber {
    private final int num;

    private NaturalNumber(int num){
        validate(num);
        this.num = num;
    }

    private static void validate(int num){
        if(num < 1){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_OF_PERSON.getMessage());
        }
    }

    public static NaturalNumber of(int num){
        return new NaturalNumber(num);
    }

    public int getNum(){        //원시값 반환
        return num;
    }
}
