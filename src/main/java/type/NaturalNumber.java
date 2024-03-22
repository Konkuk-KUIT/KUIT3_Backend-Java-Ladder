package type;

public class NaturalNumber {

    private int num;

    public NaturalNumber(int num) {
        validateNumber(num);
        this.num = num;
    }

    private void validateNumber(int num) {
        if(num < 1)
            throw new RuntimeException("Natural numbers must be integers greater than zero.");
    }

    public int getValue() {
        return num;
    }

}
