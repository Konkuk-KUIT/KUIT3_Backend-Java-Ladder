package Numbers;

public class Position implements Number {
    final private int position;
    //final private int PersonLimit;
    //final private int personNum;
    //NaturalNum보다 int 가 좋은 건가?
    private Position(int pos/*,int person*/){
        this.position = pos;
        //this.PersonLimit = person;
    }

    public static Position of(int pos) throws IllegalArgumentException{
        Position newPosition = new Position(pos);
        return newPosition;
    }
    public Position next(){
        return Position.of(position +1/*,PersonLimit*/);
        //불변 객체로 만들어 이렇게 반환하는 것이 나을까 아님 하나의 position을 돌려가면 쓰는 것이 좋을까
    }
    public Position prev(){
        return Position.of(position-1/*,PersonLimit*/);
    }

    public int get(){
        return position;
    }
}
