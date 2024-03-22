package ladder;

import ladder.ExceptionMessage;

public class NaturalNumber {
    private final int number;

    private NaturalNumber(int number) {
        validate(number);
        this.number = number;
    }

    private static void validate(int number) {
        if (!isNaturalNumber(number)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LADDER_POSITION.getMessage());
        }
    }

    private static boolean isNaturalNumber(int number) {
        return number >= 1;
    }

    public int getNumber() {
        return number;
    }


    public static NaturalNumber of(int number) {
        return new NaturalNumber(number);
    }

}