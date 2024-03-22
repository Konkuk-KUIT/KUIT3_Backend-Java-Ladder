package ladder;

// 원시타입 int 와 달리 역할 명시
// 이후 rowNum 등 다른 요소 추가 가능
public final class Position {
    private final int colNum;

    private Position(int colNum) {
        this.colNum = colNum;
    }

    public static Position at(int colNum) {
        return new Position(colNum);
    }

    public int getColNum() {
        return colNum;
    }
}