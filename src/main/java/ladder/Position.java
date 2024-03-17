package ladder;

import java.util.Objects;

public class Position {
    private int position;

    public Position(int position){
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public Position increment(){
        return new Position(position+1);
    }

    public Position decrement(){
        return new Position(position-1);
    }

    public static Position fromValue(int val){
        return new Position(val);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Position other = (Position) obj;
        return Objects.equals(getPosition(), other.getPosition());
    }
}
