package ladder;

public enum Direction {
    // direction 값 제한(두 칸 이상 넘어가는 선은 그을 수 x)
    // 방향 직관적으로 표현 가능
    NONE(0),
    RIGHT(1),
    LEFT(-1);
    private final int colDiff;
    Direction(int direction) {
        this.colDiff = direction;
    }

    @Override
    public String toString() {
        return String.valueOf(colDiff);
    }

    public int getColDiff() {
        return colDiff;
    }
}
