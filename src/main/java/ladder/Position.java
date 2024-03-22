package ladder;
import static ladder.ExceptionMessage.*;
public class Position {

    private final int position;

    private Position(int position) {
        this.position = position;
    }

    public static Position of(int position) {
        validatePosition(position);
        return new Position(position);
    }

    public int getValue() {
        return position;
    }

    private static void validatePosition(int position) {
        // 사람의 수가 n 명 이라면, 가능한 위치는 0 ~ n-1
        // n-1 조건은 어떻게 넣나요???
        if (position < 0) {
            throw new IllegalArgumentException(INVALID_POSITION.getMessage());
        }
    }
    public Position prev() {
        return of(position - 1);
    }

    public Position next() {
        return of(position + 1);
    }


    // 포지션을 가져와 필드와 작은지 비교하는 메서드
    public boolean isSmallerThan(int position) {
        return this.position < position;
    }

    // 포지션을 가져와 필드와 큰지 비교하는 메서드
    public boolean isBiggerThan(int position) {
        return this.position > position;
    }
}
