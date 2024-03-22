package ladder;

import java.util.Objects;

public class Cordinate {

    private final int row;
    private final int col;

    private Cordinate(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public static Cordinate of(int row, int col) {
        return new Cordinate(row, col);
    }

    public static Cordinate ofIntPosition(int row, Position position) {
        return new Cordinate(row, position.get());
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
        Cordinate cordinate = (Cordinate) o;
        return row == cordinate.row && col == cordinate.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}
