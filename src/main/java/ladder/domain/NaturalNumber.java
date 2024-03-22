package ladder.domain;

import static ladder.exception.ExceptionMessage.INVALID_NATURAL_NUMBER;

public class NaturalNumber {
    private final int num;

    private static boolean isNaturalNumber(int num){
        return num >= 1;
    }

    private void validateNaturalNumber(int num){
        // num이 자연수인지 검증
        if (!isNaturalNumber((num))) {
            throw new IllegalArgumentException(INVALID_NATURAL_NUMBER.getMessage());
        }
    }

    private NaturalNumber(int num) {
        validateNaturalNumber(num);
        this.num = num;
    }

    public int getNum()  {
        // 검증된 num 반환
        return num;
    }

}
