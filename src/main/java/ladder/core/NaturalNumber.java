package ladder.core;

import ladder.exception.ExceptionMessage;

public class NaturalNumber {
    private final int num;

    private NaturalNumber(int num) {
        validate(num);
        this.num = num;
    }

    public static NaturalNumber of(int num){
        return new NaturalNumber(num);
    }

    public int get() {
        return num;
    }

    private void validate(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NATURAL_NUMBER.getMessage());
        }
    }
}

