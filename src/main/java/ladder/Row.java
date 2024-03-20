package ladder;

public class Row {
    private int[] row;

    // 방향을 나타내는 상수 정의
    public static final int LEFT_LINE = -1;
    public static final int RIGHT_LINE = 1;
    public static final int MINIMUM_NUMBER_OF_PERSON = 1;
    public static final int MAXIMUM_INVALID_POSITION_NUMBER = 0;
    public Row(int numberOfPerson) {
        validateNumberOfPerson(numberOfPerson);
        row = new int[numberOfPerson];
    }

    // 사다리 행에 가로선은 그리는 역할
    public void drawLine(int lineStartPosition) {
        validateDrawLinePosition(lineStartPosition);
        row[lineStartPosition] = RIGHT_LINE;
        row[lineStartPosition + 1] = LEFT_LINE;
    }

    //현재위치 position에서 다음 위치를 계산해서 변환
    public int nextPosition(int position) {

        validatePosition(position);

        if (isLeft(position)) {
            return position - 1;
        }
        if (isRight(position)) {
            return position + 1;
        }

        return position;
    }

    private boolean isLeft(int position) {
        return row[position] == -1;
    }

    private boolean isRight(int position) {
        return row[position] == 1;
    }

    private void validateNumberOfPerson(int numberOfPerson) {
        if(numberOfPerson < MINIMUM_NUMBER_OF_PERSON) {
            throw new IllegalArgumentException("게임의 참여자 수는 1명 이상이어야 합니다.");
        }
    }

    private void validateDrawLinePosition(int lineStartPosition) {
        if(lineStartPosition < MAXIMUM_INVALID_POSITION_NUMBER || lineStartPosition >= row.length - 1 || row[lineStartPosition] == LEFT_LINE || row[lineStartPosition + 1] == RIGHT_LINE) {
            throw new IllegalArgumentException("라인 생성이 불가능한 위치 입니다.");
        }
    }

    private void validatePosition(int position) {
        if(position >= row.length || position < MAXIMUM_INVALID_POSITION_NUMBER ) {
            throw new IllegalArgumentException("유효하지 않은 위치 입니다.");
        }
    }




}
