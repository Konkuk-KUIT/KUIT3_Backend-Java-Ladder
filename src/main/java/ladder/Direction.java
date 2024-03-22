package ladder;

public enum Direction {
    RIGHT(1),
    LEFT(-1),
    NONE(0);

    private final int direction;

    Direction(int direction) {
        this.direction = direction;
    }


    // 게임 실행 중 결과 출력을 위해, 값 가져오기
    public int getDirection() {
        return direction;
    }
}
