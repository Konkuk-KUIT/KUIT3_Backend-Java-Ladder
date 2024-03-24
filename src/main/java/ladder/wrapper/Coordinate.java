package ladder.wrapper;

import java.util.Objects;

public class Coordinate {

    private final int row;
    private final int col;

    private Coordinate(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public static Coordinate of(int row, int col) {
        return new Coordinate(row, col);
    }

    public static Coordinate ofIntPosition(int row, Position position) {
        return new Coordinate(row, position.get());
    }

    public int getRowIndex() {
        return row;
    }

    public int getColIndex() {
        return col;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Coordinate coordinate = (Coordinate) o;
        return row == coordinate.row && col == coordinate.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}
