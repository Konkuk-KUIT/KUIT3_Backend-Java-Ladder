package ladder;

public class NaturalNumber {
    private final int num;

    private NaturalNumber(int num) {
        validate(num);
        this.num = num;
    }
    public int getNum() {
        return num;
    }
    private void validate(int num){
        if(num<1){throw new IllegalArgumentException(String.valueOf(ExeptionMessage.NOT_NATURAL_NUMBER));}
    }
    public static NaturalNumber of(int num){
        return new NaturalNumber(num);
    }
}
