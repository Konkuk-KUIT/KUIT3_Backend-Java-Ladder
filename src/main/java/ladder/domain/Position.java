package ladder.domain;

import static ladder.exception.ExceptionMessage.INVALID_LADDER_POSITION;

public class Position {
    private int position;

    private Position(int position) {
        validatePosition(position);
        this.position = position;
    }

    // 정적 팩토리 메소드
    public static Position of(int position){
        return new Position(position);
    }

    public Position prevPosition(){
        return of(position - 1);
    }

    public Position nextPosition() {
        return of(position + 1);
    }

    public int getValue(){
        return position;
    }

    public boolean isBiggerThan(int position){
        return this.position > position;
    }

    public boolean isSmallerThan(int position){
        return this.position < position;
    }

    // 유효성 검증
    private void validatePosition(int position) {
        if(!isPositionValid(position)) {
            throw new IllegalArgumentException(INVALID_LADDER_POSITION.getMessage());
        }
    }

    private static boolean isPositionValid(int position){
        return position >= 0;
    }
}
