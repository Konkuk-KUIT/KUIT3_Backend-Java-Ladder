package ladder.data;

import type.Position;

public class LadderPosition {

    private final Position x;
    private final Position y;

    public LadderPosition(int x, int y) {
        try {
            this.x = new Position(x);
            this.y = new Position(y);
        } catch (Exception e) {
            throw new RuntimeException("Ladder position values is not correct.");
        }
    }

    public void movePosition(int dx, int dy) {
        x.movePosition(dx);
        y.movePosition(dy);
    }

    public int getXPosition() {
        return x.getPosition();
    }

    public int getYPosition() {
        return y.getPosition();
    }

}
