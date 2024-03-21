package ladder;

public class NaturalNumber {
    private final int num;

    public static NaturalNumber of(int num){
        return new NaturalNumber(num);
    }

    private NaturalNumber(int num){
        validate(num);
        this.num = num;
    }

    public void validate(int num){
        if(num < 1) throw new IllegalArgumentException("자연수는 0보다 커야합니다.");
    }

    public int get(){
        return this.num;
    }
}
