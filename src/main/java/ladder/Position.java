package ladder;

public class Position {
    private final int position;
    private Position(int position){
        this.position = position;
    }


    // 밑에처럼 사람 수 받아워서 validation하는게 좀 어색함.
    // 그렇다고 안받아오면 사람수 넘게 position이 입력됐는지 validation하기 어려움.

    static public Position of(int position){

        validationPosition(position);
        return new Position(position);
    }

    private static void validationPosition(int position) {
        // row 수정후에 다시 수정
        if(position < 0 ) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_POSITION.getExceptionMessage());
        }
    }
    public Position prev(){
        return new Position(position -1);
    }


    public Position next() {
        return new Position(position + 1);
    }


    public int getValue(){
        return position;
    }

}
