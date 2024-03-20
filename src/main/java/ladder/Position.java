package ladder;

public class Position {
    private int position;

    private Position(int position) {
        validatePosition(position);
        this.position = position;
    }

    public static Position of(int position) {
        return new Position(position);
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
            throw new IllegalArgumentException("위치는 양의 정수입니다.");
        }
    }
}