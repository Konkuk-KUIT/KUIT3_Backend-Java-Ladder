package ladder.model;

import java.util.Objects;

import static ladder.exception.ExceptionMessage.DUPLICATE_LINE;
import static ladder.exception.ExceptionMessage.INVALID_POSITION;

public class Position {
    private int position;

    public Position(int position){
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public Position increment(){
        return fromValue(position+1);
    }

    public Position decrement(){
        return fromValue(position-1);
    }

    public static Position fromValue(int val){
        if(val < 0) new IllegalArgumentException(INVALID_POSITION.getMessage());
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
