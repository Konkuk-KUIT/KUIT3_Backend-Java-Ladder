package ladder;

public class Position {
    private int position;

    private Position(int value){
        this.position = value;
    }
    public static Position of(int value){
        validatePosition(value);
        //생성자 리턴
        return new Position(value);
    }
    public Position prev(){
        return of(position -1);
    }
    public Position next(){ return of(position +1); }

    //정답코드에는 isSmallerThan()
    //isBiggerThan()

    public int getPosition(){
        return position;
    }
    private static void validatePosition(int position){
        if(position < 0 ) {
            throw new IllegalArgumentException(ExceptionMessage.INVAILD_LADDER_POSITION.getValue());
        }
    }
}
