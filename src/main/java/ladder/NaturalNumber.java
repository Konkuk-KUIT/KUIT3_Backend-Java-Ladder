package ladder;

public class NaturalNumber {

    private final int num;

    private NaturalNumber(int value){
        this.num = value;
    }
    private static void validate(int value){
        if (!(value>0 || value<Integer.MAX_VALUE)){
            throw new IndexOutOfBoundsException(ExceptionMessage.INVAILD_LADDER_POSITION.getValue());
        }
    }
    public int getNum(){
        return num;
    }
    public static NaturalNumber of(int num){
        validate(num);
        //생성자 리턴
        return new NaturalNumber(num);
    }

}
