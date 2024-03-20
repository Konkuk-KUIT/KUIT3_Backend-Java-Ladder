package ladder;

public class NaturalNumber {
    private final int num;

    public NaturalNumber(int num) {
        validate();
        this.num =num;
    }
    public int get(){
        return num;
    }
    private void validate(){
        if(num<=0){
            throw new IllegalArgumentException("자연수가 아닙니다");
        }
    }
}
