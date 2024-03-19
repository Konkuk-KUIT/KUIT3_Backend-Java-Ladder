package ladder;

public class NaturalNumber {
    private final int num;

    private NaturalNumber(int num) {
        validate(num);
        this.num = num;
    }

    public static NaturalNumber of(int num) {
        return new NaturalNumber(num);
    }

    public int get() {
        return num;
    }

    private void validate(int num) {
        if (num < 1) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_IS_NOT_NATURAL_NUMBER.getMessage());
        }
    }
}