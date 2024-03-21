package ladder;

public class NaturalNumber {

    private final int value;

    public NaturalNumber(int value) {
        validate(value);
        this.value = value;
    }

    public static NaturalNumber of(int value){
        return new NaturalNumber(value);
    }

    public  int getValue() {
        return value;
    }

    private void validate(int value){
        if(!isNaturalNumber(value)){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NATURAL_NUMBER.getMessage());
        }
    }

    private static boolean isNaturalNumber(int value){
        return value >=1;
    }
}



