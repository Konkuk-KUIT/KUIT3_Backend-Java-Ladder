package ladder;

public class NaturalNumber {

    private final int value;

    public NaturalNumber(int value) {
        if(value <= 0){
            throw  new IllegalArgumentException("자연수는 1 이상이어야 합니다.");
        }
        this.value = value;
    }

    public  int getValue() {
        return value;
    }
}



