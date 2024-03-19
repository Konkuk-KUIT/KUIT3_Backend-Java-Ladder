package ladder;

public class Row {
    private int[] row;
    private Node[] nodes;

    public Row(int numberOfPerson) {
        validateNumberOfPerson(numberOfPerson);
        row = new int[numberOfPerson];

        nodes = new Node[numberOfPerson];
        for(int i=0;i<numberOfPerson;i++){
            nodes[i] = Node.SetNode(Direction.NONE);
        }

    }

    public void drawLine(int lineStartPosition) {
        validateDrawLinePosition(lineStartPosition);
        row[lineStartPosition] = 1;
        row[lineStartPosition + 1] = -1;

        //validate
        nodes[lineStartPosition] = Node.SetNode(Direction.RIGHT);
        nodes[lineStartPosition+1] = Node.SetNode(Direction.LEFT);
    }

    public int nextPosition(int position) {

        validatePosition(position);

        Direction Dir = nodes[position].NextPosition();

        if (Direction.LEFT.equals(Dir)) {
            return position - 1;
        }
        if (Direction.RIGHT.equals(Dir)) {
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
        if(numberOfPerson < 1) {
            throw new IllegalArgumentException("게임의 참여자 수는 1명 이상이어야 합니다.");
        }
    }

    private void validateDrawLinePosition(int lineStartPosition) {
        if(lineStartPosition < 0 || lineStartPosition >= row.length - 1 || row[lineStartPosition] == -1 || row[lineStartPosition + 1] == 1) {
            throw new IllegalArgumentException("라인 생성이 불가능한 위치 입니다.");
        }
    }

    private void validatePosition(int position) {
        if(position >= row.length || position < 0 ) {
            throw new IllegalArgumentException("유효하지 않은 위치 입니다.");
        }
    }




}
