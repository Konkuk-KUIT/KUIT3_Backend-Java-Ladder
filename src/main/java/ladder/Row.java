package ladder;

import java.util.Arrays;

public class Row {
    private Direction[] row;

    public Row(NaturalNumber numberOfPerson) {
//        validateNumberOfPerson(numberOfPerson.get());     // Natural Number에서 이미 validate함
        row = new Direction[numberOfPerson.get()];
        Arrays.fill(row, Direction.CENTER);
    }

    public void drawLine(Position lineStartPosition) {   // 오른쪽 찍 한줄 긋기
        validateDrawLinePosition(lineStartPosition.get());
        row[lineStartPosition.get()] = Direction.RIGHT;
        row[lineStartPosition.next().get()] = Direction.LEFT;
    }

    public Position nextPosition(Position position) { // run 할때 직접, 얼마나 내려왔는지 계산(?) 생각(?) 해야됨 -> 이미 ladder의 run에 이와 비슷하게 구현 되있슴

//        validatePosition(position); // 맨처음 사용자 입력? 이때만 Exception 터지지 그 외 프로그램이 돌면서는 안 터질꺼 같은데...? 사다리가 맛 가지 않은 이상 --> 사다리나 row가 잡아내라~
        // 차피 돼서 나옴
        if (isLeft(position)) {
            return position.prev();
        }
        if (isRight(position)) {
            return position.next();
        }

        return position;
    }

    private boolean isLeft(Position position) {
        return row[position.get()] == Direction.LEFT;
    }

    private boolean isRight(Position position) {
        return row[position.get()] == Direction.RIGHT;
    }

//    private void validateNumberOfPerson(int numberOfPerson) {   // Natural Number에서 미리 검증 했습니다~
//        if(numberOfPerson < 1) {
//            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_OF_PERSON.getErrorMessage());
//        }
//    }

    private void validateDrawLinePosition(int lineStartPosition) {
        if(lineStartPosition < 0 || lineStartPosition >= row.length - 1 || row[lineStartPosition] == Direction.LEFT
                || row[lineStartPosition + 1] == Direction.RIGHT) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DRAW_LINE_POSITION.getErrorMessage());
        }
    }

//    private void validatePosition(int position) {   // Position에서 이미 검증 함
//        if(position >= row.length || position < 0 ) {
//            throw new IllegalArgumentException(ExceptionMessage.INVALID_POSITION.getErrorMessage());
//        }
//    }
}
