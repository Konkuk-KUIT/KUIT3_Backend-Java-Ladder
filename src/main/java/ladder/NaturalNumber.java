package ladder;

public class NaturalNumber {
    private final int num;
    private NaturalNumber(int num){
        this.num = num;
    }

    public static NaturalNumber numberOfPersonOf(int num){
        validationNumberOfPerson(num);
        return new NaturalNumber(num);
    }

    public static NaturalNumber numberOfRowOf(int num){
        validationNumberOfRow(num);
        return  new NaturalNumber(num);
    }


    private static void validationNumberOfPerson(int num) {
        if(num < 1) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_OF_PERSON.getExceptionMessage());
        }
    }

    private static void validationNumberOfRow(int num) {
        if(num < 1) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_OF_ROW.getExceptionMessage());
        }
    }


    public int getNum() {
        return num;
    }
}
