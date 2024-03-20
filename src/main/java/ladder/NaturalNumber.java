package ladder;

public class NaturalNumber {
    private int value;

    public NaturalNumber(int value) {
        validateValue(value);
        this.value = value;
    }

    public void validateValue(int size) {
        if (size < 1)
            throw new IllegalArgumentException("자연수는 1 이상의 정수여야 합니다.");
    }

    public int size() {
        return value;
    }
}
