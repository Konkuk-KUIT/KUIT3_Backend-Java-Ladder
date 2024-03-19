package ladder;

public class Position {
    private final int position;

    private Position(int position, NaturalNumber numberOfPerson) {
        validate(position, numberOfPerson);     // 우리가 입력준거만 확인 하면 되지... 나머지는 사다리, row 탓~
        this.position = position;
    }

    private Position(int position) {
        this.position = position;
    }

    public static Position initFrom(int position, NaturalNumber numberOfPerson) {   // int or NaturalNumber?
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
}
