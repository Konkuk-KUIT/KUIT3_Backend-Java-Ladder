package ladder.model;

import java.util.Objects;

public class LadderPosition {
    private final Position row;
    private final Position col;

    private LadderPosition(Position row, Position col) {
        this.row = row;
        this.col = col;
    }

    public Position getRow() {
        return row;
    }

    public Position getCol() {
        return col;
    }

    public static LadderPosition of(Position row, Position col){
        return new LadderPosition(row,col);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LadderPosition other = (LadderPosition) obj;
        return Objects.equals(getRow(), other.getRow()) && Objects.equals(getCol(), other.getCol());
    }


}
