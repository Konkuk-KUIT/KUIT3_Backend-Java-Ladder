package ladder;

public class Position {
    private int position;

    private Position(int position) {
        this.position = position;
    }

    public static Position of(int num){
        validatePosition(num);
        return new Position(num);
    }

    public int getPosition() {
        return position;
    }

    public Position prev() {
        return new Position(position - 1);
    }

    public Position next() {
        return new Position(position + 1);
    }

    private static void validatePosition(int num){
        if(num<0){throw new IllegalArgumentException(String.valueOf(ExeptionMessage.NOT_VALID_NUMBER));}
    }
}
