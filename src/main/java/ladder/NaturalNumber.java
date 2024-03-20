package ladder;

public class NaturalNumber {
    private final int num;

    public NaturalNumber(int num) {
        this.num =num;
    }
    public static NaturalNumber of(int num) {
        validate(num);
        return new NaturalNumber(num);
    }


    public int get(){
        return num;
    }
    private static void validate(int num){
        if(num<=0){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NATURAL_NUMBER.getMessage());
        }
    }
}
