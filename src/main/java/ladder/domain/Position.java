package ladder.domain;

import ladder.exception.ExceptionMessage;

public class Position {
    private int position;

    public static Position of(int position){
        return new Position(position);
    }

    private Position(int position){
        validatePosition(position);
        this.position = position;
    }

    public Position prev(){
        return new Position(position - 1);
    }

    public Position next(){
        return new Position(position + 1);
    }

    public void validatePosition(int position){
        if(position < 0)
            throw new IllegalArgumentException(ExceptionMessage.INVALID_POSITION.getMessage());
    }

    public int get(){
        return this.position;
    }

    // position의 값이 상한을 넘는지 확인하기 위해서 이 메소드를 도입
    public boolean isBiggerThan(int position){
        return this.position > position;
    }
}
