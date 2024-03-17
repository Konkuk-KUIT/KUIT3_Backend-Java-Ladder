package ladder;

import static ladder.ExceptionMessage.INVALID_NATURAL_NUMBER;

public class NaturalNumber {

    private final int number;

    public NaturalNumber(int number) {
        validateNumber(number);
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    public static NaturalNumber of(int number) {
        return new NaturalNumber(number);
    }

    private void validateNumber(int number) {
        if(!isNaturalNumber(number)) {
            throw new IllegalArgumentException(INVALID_NATURAL_NUMBER.getMessage());
        }
    }

    private boolean isNaturalNumber(int number) {
        return number >= 1;
    }
}
