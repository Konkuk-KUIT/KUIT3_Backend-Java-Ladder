package domain;

public class Position {
    private int position;
    private NaturalNumber numberOfPerson;

    private Position(int position){
        validatePosition(position);
        this.position = position;
    }

    public Position next(){
        return of(position + 1);
    }

    public Position prev(){
        return of(position + 1);
    }

    private void validatePosition(int position){
        if(position < 0){
            throw new IllegalArgumentException("사다리 상의 사람의 수가 잘못입력되었습니다.");
        }
    }
    public int getPosition() {      //원시값 반환
        return position;
    }

    public static Position of(int position){
        return new Position(position);
    }

    // 이후 기존에 생각하지 못했던 메서드들

    // 포지션을 가져와 필드와 작은지 비교하는 메서드
    public boolean isSmallerThan(int position) {
        return this.position < position;
    }

    // 포지션을 가져와 필드와 큰지 비교하는 메서드
    public boolean isBiggerThan(int position) {
        return this.position > position;
    }
}
