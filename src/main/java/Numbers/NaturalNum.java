package Numbers;

public class NaturalNum implements Number {
    private final int number;

    private NaturalNum(int num){
        this.number = num;
    }

    public static NaturalNum of(int num) throws IllegalArgumentException{
        if(NaturalNum.validate(num)){
            return new NaturalNum(num);
        }else{
            throw new IllegalArgumentException("자연수가 아닙니다");
        }
    }
    public int get(){
        return number;
    }
    private static boolean validate(int num){
        if(num <= 0 ){
            return false;
        }
        return true;
    }

}
