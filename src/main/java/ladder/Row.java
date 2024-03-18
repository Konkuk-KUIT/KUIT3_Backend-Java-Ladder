package ladder;

import java.util.Arrays;

public class Row {
    private Direction[] row;

    public Row(int numberOfPerson) {
        validateNumberOfPerson(numberOfPerson);
        row = new Direction[numberOfPerson];
        Arrays.fill(row, Direction.CENTER);
    }

    public void drawLine(int lineStartPosition) {   // 오른쪽 찍 한줄 긋기
        validateDrawLinePosition(lineStartPosition);
        row[lineStartPosition] = Direction.RIGHT;
        row[lineStartPosition + 1] = Direction.LEFT;
    }

    public int nextPosition(int position) { // run 할때 직접, 얼마나 내려왔는지 계산(?) 생각(?) 해야됨 -> 이미 ladder의 run에 이와 비슷하게 구현 되있슴

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
        return row[position] == Direction.LEFT;
    }

    private boolean isRight(int position) {
        return row[position] == Direction.RIGHT;
    }

    private void validateNumberOfPerson(int numberOfPerson) {
        if(numberOfPerson < 1) {
            throw new IllegalArgumentException("게임의 참여자 수는 1명 이상이어야 합니다.");
        }
    }

    private void validateDrawLinePosition(int lineStartPosition) {
        if(lineStartPosition < 0 || lineStartPosition >= row.length - 1 || row[lineStartPosition] == Direction.LEFT
                || row[lineStartPosition + 1] == Direction.RIGHT) {
            throw new IllegalArgumentException("라인 생성이 불가능한 위치 입니다.");
        }
    }

    private void validatePosition(int position) {
        if(position >= row.length || position < 0 ) {
            throw new IllegalArgumentException("유효하지 않은 위치 입니다.");
        }
    }




}
