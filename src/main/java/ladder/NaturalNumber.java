package ladder;

public class NaturalNumber {
    private final int number;
    private static final String ERROR_IS_NOT_NATURAL_NUMBER = "1 이상의 숫자여야 합니다.";
    public NaturalNumber(int number) {
        if(number < 1) {
            throw new IllegalArgumentException(ERROR_IS_NOT_NATURAL_NUMBER);
        }
        this.number = number;
    }

    public int toInt() {
        return number;
    }
}
