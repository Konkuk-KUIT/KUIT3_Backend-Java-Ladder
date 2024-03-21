package ladder.wrapper;

import ladder.util.ExceptionMessage;

public class NaturalNumber {
    private final int num;

    private NaturalNumber(int num) {
        validateNumber(num);
        this.num = num;
    }

    public static NaturalNumber of(int num) {
        return new NaturalNumber(num);
    }

    private void validateNumber(int num) {
        if (num < 1)
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NATURAL_NUMBER.get());
    }

    public int get() {
        return num;
    }
}
