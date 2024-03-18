package ladder;

import ladder.util.CustomException;
import ladder.util.ErrorCode;
import ladder.util.RowConstant;

public class Row {
    private int[] row;

    public Row(int numberOfPerson) {
        validateNumberOfPerson(numberOfPerson);
        row = new int[numberOfPerson];
    }

    public void drawLine(int lineStartPosition) {
        validateDrawLinePosition(lineStartPosition);
        row[lineStartPosition] = RowConstant.RIGHT_DRAW_CONSTANT;
        row[lineStartPosition + RowConstant.ROW_BLOCK_SIZE] = RowConstant.LEFT_DRAW_CONSTANT;
    }

    public int nextPosition(int position) {

        validatePosition(position);

        if (isLeft(position)) {
            return position + RowConstant.LEFT_DRAW_CONSTANT;
        }
        if (isRight(position)) {
            return position + RowConstant.RIGHT_DRAW_CONSTANT;
        }

        return position;
    }

    private boolean isLeft(int position) {
        return row[position] == RowConstant.LEFT_DRAW_CONSTANT;
    }

    private boolean isRight(int position) {
        return row[position] == RowConstant.RIGHT_DRAW_CONSTANT;
    }

    private void validateNumberOfPerson(int numberOfPerson) {
        if(numberOfPerson < 1) {

            //throw new IllegalArgumentException("게임의 참여자 수는 1명 이상이어야 합니다.");
            throw new CustomException(ErrorCode.LACK_PARTICIPANTS);
        }
    }

    private void validateDrawLinePosition(int lineStartPosition) {
        if(lineStartPosition < RowConstant.START_INDEX || lineStartPosition >= row.length - 1 || row[lineStartPosition] == RowConstant.LEFT_DRAW_CONSTANT || row[lineStartPosition + RowConstant.ROW_BLOCK_SIZE] == RowConstant.RIGHT_DRAW_CONSTANT) {
            throw new CustomException(ErrorCode.INVALID_LINE_POSITION);
        }
    }

    private void validatePosition(int position) {
        if(position >= row.length || position < RowConstant.START_INDEX ) {
            throw new CustomException(ErrorCode.INVALID_POSITION);
        }
    }




}
