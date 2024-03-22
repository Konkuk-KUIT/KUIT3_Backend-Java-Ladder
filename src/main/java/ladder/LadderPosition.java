package ladder;

import domain.Position;

public class LadderPosition {
    private Position x;
    private Position y;

    private LadderPosition(Position x, Position y){
        this.x = x;
        this.y = y;
    }

    public static LadderPosition of(Position x, Position y){
        return new LadderPosition(x, y);
    }

    public Position getX() {
        return x;
    }

    public Position getY() {
        return y;
    }
}
