package type;

// class that used as index value for an array
public class Position {

    public static final int MIN_POSITION = 0;
    int pos;

    public Position(int pos) {
        validatePosition(pos);
        this.pos = pos;
    }

    private void validatePosition(int pos) {
        if(pos < MIN_POSITION) throw new RuntimeException("Position value must be greater than zero.");
    }

    public int movePosition(int num) {
        pos += num;
        if(pos < 0) throw new RuntimeException("Position values cannot be negative.");
        return pos;
    }

    public int increase() {
        return ++pos;
    }

    public int decrease() {
        return --pos;
    }

    public int getPosition() {
        return pos;
    }

}
