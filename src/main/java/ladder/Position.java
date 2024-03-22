package ladder;

import java.util.Objects;

public class Position {
    private final int position;

    private Position(int position, NaturalNumber numberOfPerson) {
        validate(position, numberOfPerson);
        this.position = position;
    }

    private Position(int position) {
        this.position = position;
    }

    public static Position initOf(int position, NaturalNumber numberOfPerson) {   // int or NaturalNumber?
        return new Position(position, numberOfPerson);
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

    private void validate(int position, NaturalNumber numberOfPerson) {
        if(position < 0 || position >= numberOfPerson.get()) {
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
