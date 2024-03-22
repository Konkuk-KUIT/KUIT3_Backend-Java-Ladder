package ladder;

import java.util.Objects;

public class Position {
    private final int position;

    private Position(int position) {
        validate(position);
        this.position = position;
    }

    public static Position from(int position) {
        return new Position(position);
    }

    public int get() {
        return this.position;
    }

    public Position prev() {
        return new Position(this.position - 1);
    }

    public Position next() {
        return new Position(this.position + 1);
    }

    private void validate(int position) {
        if(position < 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_POSITION.getErrorMessage());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
