package ladder;

import ladder.exception.ExceptionMessage;

public class Position {
    private int position;

    private Position(int position) {
        validatePosition(position);
        this.position = position;
    }

    public static Position of(int position) {
        return new Position(position);
    }
    public int getValue() {
        return this.position;
    }

    public int getPosition() {
        return position;
    }

    public Position prev() {
        return of(position - 1);
    }

    public Position next() {
        return of(position + 1);
    }

    private void validatePosition(int position) {
        //사다리 사람의 수 설정
        if (position < 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NATURAL_NUMBER.getMessage());
        }
    }

    public boolean isSmallerThan(int position) {
        return this.position < position;
    }

    public boolean isBiggerThan(int position) {
        return this.position > position;
    }
}