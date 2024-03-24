package ladder.wrapper;

import java.util.List;
import ladder.exception.ExceptionMessage;

public class LadderSpec {
    private final NaturalNumber numberOfRows;
    private final NaturalNumber numberOfPerson;
    private final List<Coordinate> sideLadders;

    public LadderSpec(NaturalNumber numberOfRows, NaturalNumber numberOfPerson, List<Coordinate> sideLadders) {
        this.numberOfRows = numberOfRows;
        this.numberOfPerson = numberOfPerson;
        this.sideLadders = sideLadders;
        validate();
    }

    private void validate() {
        for(Coordinate sideLadder : this.sideLadders) {
            validateOutOfBound(sideLadder);
        }
        validateDuplicates();
    }

    private void validateOutOfBound(Coordinate sideLadder) { // numberofPerson에 -1이 있는 이유 얘는 오른쪽 찍이라 맨 오른쪽에 생성 안됨
        if(sideLadder.getRowIndex() >= numberOfRows.get() || sideLadder.getColIndex() >= numberOfPerson.get() - 1) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_SIDE_LADDER.getErrorMessage());
        }
    }

    private void validateDuplicates() {
        int[][] visited = new int[numberOfRows.get()][numberOfPerson.get()];
        for(Coordinate sideLadder : sideLadders) {
            if(visited[sideLadder.getRowIndex()][sideLadder.getColIndex()] == 1
            || visited[sideLadder.getRowIndex()][sideLadder.getColIndex() + 1] == 1) { // 얘는 봐줘잉
                throw new IllegalArgumentException(ExceptionMessage.INVALID_SIDE_LADDER.getErrorMessage());
            }
            visited[sideLadder.getRowIndex()][sideLadder.getColIndex()] = 1;
            visited[sideLadder.getRowIndex()][sideLadder.getColIndex() + 1] = 1;
        }
    }
    public int getNumberOfRows() {
        return this.numberOfRows.get();
    }

    public int getNumberOfPerson() {
        return this.numberOfPerson.get();
    }

    public List<Coordinate> getSideLadders() {
        return sideLadders;
    }
}
