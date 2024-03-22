package model;

public class NaturalNumber {
    private int naturalNumber;

    public NaturalNumber(int naturalNumber){
        validate(naturalNumber); //자연수인지 유효성 검사
        this.naturalNumber = naturalNumber;
    }
    public static NaturalNumber of(int naturalNumber){
        NaturalNumber nm = new NaturalNumber(naturalNumber);
        return nm;
    }
    public int getNaturalNumber(){
        return naturalNumber;
    }
    private void validate(int naturalNumber){
        if(!isNaturalNumber(naturalNumber)){
            throw new IllegalArgumentException(ExceptionMessage.NOT_NATURAL_NUMBER.getExceptionMessage());
        }
    }

    private boolean isNaturalNumber(int naturalNumber) {
        if(naturalNumber>=1){
            return true;
        }
        else return false;
    }
}
