package ladder.domain;

public class Position {
    private int position;

    private Position(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    // 정적 팩토리 메소드
    public static Position of(int position){
        return new Position(position);
    }
}
