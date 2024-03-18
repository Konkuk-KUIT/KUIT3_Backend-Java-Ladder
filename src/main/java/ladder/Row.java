package ladder;

public class Row {
    private int[] row;

    public Row(int numberOfPerson) {
        validateNumberOfPerson(numberOfPerson);
        row = new int[numberOfPerson];
    }

    private void validateNumberOfPerson(int numberOfPerson) {
        if (numberOfPerson < 1)
            throw new IllegalArgumentException("게임의 참여자 수는 1명 이상이어야 합니다.");
    }

    public void drawLine(int lineStartPosition) {
        validateLineStartPosition(lineStartPosition);
        row[lineStartPosition] = 1;
        row[lineStartPosition + 1] = -1;
    }

    private void validateLineStartPosition(int lineStartPosition) {
        if (lineStartPosition < 0 || lineStartPosition >= row.length - 1 ||
                row[lineStartPosition] == -1 || row[lineStartPosition + 1] == 1)
            throw new IllegalArgumentException("라인 생성이 불가능한 위치입니다.");
    }

    public int nextPosition(int position) {
        validatePosition(position);
        if (isLeft(position))
            return position - 1;
        if (isRight(position))
            return position + 1;
        return position;
    }

    private void validatePosition(int position) {
        if (position < 0 || position >= row.length)
            throw new IllegalArgumentException("유효하지 않은 위치입니다.");
    }

    private boolean isLeft(int position) {
        return row[position] == -1;
    }

    private boolean isRight(int position) {
        return row[position] == 1;
    }

    public String printRow() {
        StringBuilder rowResult = new StringBuilder();
        for (int i = 0; i < row.length; i++) {
            rowResult.append(String.valueOf(row[i]));
            rowResult.append(' ');
        }
        rowResult.append('\n');
        return rowResult.toString();
    }
}
