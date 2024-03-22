package ladder.position;

import java.util.Objects;

public class LadderPosition {
    private final Position row;
    private final Position col;

    private LadderPosition(Position row, Position col) {
        this.row = row;
        this.col = col;
    }

    public static LadderPosition of(Position low, Position col){
        return new LadderPosition(low, col);
    }

    public Position getRow() {
        return row;
    }

    public Position getCol() {
        return col;
    }

    public int getRowPosition() {
        return row.getPosition();
    }

    public int getColPosition() {
        return col.getPosition();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        LadderPosition other = (LadderPosition) obj;
        return Objects.equals(row, other.row) && Objects.equals(col, other.col);
    }


    @Override
    public int hashCode() {
        // Use hash function from java.util.Objects to generate hash code
        return java.util.Objects.hash(row, col);
    }
}
