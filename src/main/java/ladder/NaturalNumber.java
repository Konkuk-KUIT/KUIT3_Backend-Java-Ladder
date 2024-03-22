package ladder;

public class NaturalNumber {
    private final int num;

    // 생성자를 외부에서 호출하지 못하도록 private로 지정
    private NaturalNumber(int num) {
        validate(num);
        this.num = num;
    }
    public static NaturalNumber of(int num) {
        return new NaturalNumber(num);
    }
    public int getNum() {
        return num;
    }

    // validate 메서드와 isNaturalNumber 메서드를 분리해, 메서드에 과도한 책임전가 X
    private void validate(int num) {
        if (!isNaturalNumber(num)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_OF_PERSON.getMessage());
        }
    }

    private static boolean isNaturalNumber(int num) {
        return num >= 1;
    }

}
