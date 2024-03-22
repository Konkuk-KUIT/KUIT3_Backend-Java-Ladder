package ladder;

import java.util.List;

public class LadderSpec {
    private final NaturalNumber numberOfRows;
    private final NaturalNumber numberOfPerson;
    private final List<Cordinate> sideLadders;

    public LadderSpec(NaturalNumber numberOfRows, NaturalNumber numberOfPerson, List<Cordinate> sideLadders) {
        this.numberOfRows = numberOfRows;
        this.numberOfPerson = numberOfPerson;
        this.sideLadders = sideLadders;
        validate();
    }

    private void validate() {
        for(Cordinate sideLadder : this.sideLadders) {
            validateOutOfBound(sideLadder);
        }
        validateDuplicates();
    }

    private void validateOutOfBound(Cordinate sideLadder) {
        if(sideLadder.getRowIndex() >= numberOfRows.get() || sideLadder.getColIndex() >= numberOfPerson.get()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_SIDE_LADDER.getErrorMessage());
        }
    }

    private void validateDuplicates() {
        int[][] visited = new int[numberOfRows.get()][numberOfPerson.get()];
        for(Cordinate sideLadder : sideLadders) {
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

    public List<Cordinate> getSideLadders() {
        return sideLadders;
    }
}
