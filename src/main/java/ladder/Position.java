package ladder;

/**
 * 필드를 position만 갖는 이유가 뭘까?
 * primitive type으로는 컴파일러가 의미적으로 프로그램 작성을 안내할 수 없다.
 * 포장한 객체를 통해 예외 처리가 가능하다.
 */

public class Position {
    private int position;

    private Position(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    /**
     * static의 특징은 무엇일까?
     * 1. 메모리에 고정적으로 할당된다.
     * 2. 객체 생성 없이 사용하 수 있다.
     * 3. 프로그램이 시작되면 메모리의 static 영역에 적재되고, 프로그램이 종료될 때 해제된다.
     * 4. Static 메서드 내에서는 인스턴스 변수를 사용할 수 없다.
     *
     * from : 하나의 매개변수를 받아서 객체를 생성
     * of : 여러 개의 매개 변수를 받아서 객체를 생성
     *
     */

    public static Position of(int position) {
        validatePosition(position);
        return new Position(position);
    }

    public Position prev() {
        // 이전 위치는 현재 위치 -1인가?
        return new Position(position - 1);
    }

    public Position next() {
        return new Position(position + 1);
    }

    private static void validatePosition(int position) {
        if(!isPosition(position)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_POSITION.getMessage());
        }
    }

    private static boolean isPosition(int position) {
        return position >= 0;
    }

    public boolean isSmallerThan(int position) {
        return this.position < position;
    }

    public boolean isBiggerThan(int position) {
        return this.position > position;
    }
}
