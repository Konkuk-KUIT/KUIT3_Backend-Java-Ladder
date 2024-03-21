package ladder;

import java.util.Objects;

public class SideLadder {   // 그저 포장
    private final int row;
    private final Position position;

    public SideLadder(int row, Position position) {
        this.row = row;
        this.position = position;
    }



    public int getRow() {
        return row;
    }

    public Position getPosition() {
        return position;
    }
}
