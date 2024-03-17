package ladder;

public class Position {

    private int position;

    Position(int position) {
        this.position = position;
    }

    public int getValue() {
        return this.position;
    }

    public static Position of(int position) {
        validatePosition(position);
        return new Position(position);
    }

    public Position next() {
        return new Position(position + 1);
    }

    public Position prev() {
        return new Position(position - 1);
    }

    public boolean isSmallerThan(int position) {
        return this.position < position;
    }

    public boolean isBiggerThan(int position) {
        return this.position > position;
    }

    public static void validatePosition(int position) {
        if(!isPosition(position)) {
            throw new IllegalArgumentException("사다리 상의 위치는 0 이상의 정수 이어야 합니다.");
        }
    }

    private static boolean isPosition(int position) {
        return position >= 0;
    }


}
