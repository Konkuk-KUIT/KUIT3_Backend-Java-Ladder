package ladder;

public class Position {
    private final int position;

    // private 생성자로 외부에서의 직접 생성을 제한합니다.
    private Position(int position) {
        this.position = position;
    }

    // 정적 팩터리 메서드를 통한 객체 생성 방법을 제공합니다.
    public static Position of(int position) {
        validatePosition(position);
        return new Position(position);
    }

    public Position prev() {
        return new Position(position - 1);
    }

    public Position next() {
        return new Position(position + 1);
    }

    // 위치 값의 유효성을 검증하는 메서드입니다.
    private static void validatePosition(int position) {
        if (position < 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LADDER_POSITION.getMessage());
        }
    }

    // position 필드의 getter 메서드를 제공할 수도 있습니다.
    public int getPosition() {
        return position;
    }
}
