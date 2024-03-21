package ladder;

import java.util.List;

public class LadderSpec {
    private final NaturalNumber numberOfRows;
    private final NaturalNumber numberOfPerson;
    private final List<SideLadder> sideLadders;

    public LadderSpec(NaturalNumber numberOfRows, NaturalNumber numberOfPerson, List<SideLadder> sideLadders) {
        this.numberOfRows = numberOfRows;
        this.numberOfPerson = numberOfPerson;
        this.sideLadders = sideLadders;
        validate();
    }

    private void validate() {
        for(SideLadder sideLadder : this.sideLadders) {
            validateOutOfBound(sideLadder);
        }
        validateDuplicates();
    }

    private void validateOutOfBound(SideLadder sideLadder) {
        if(sideLadder.getRow() >= numberOfRows.get() || sideLadder.getPosition().get() >= numberOfPerson.get()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_SIDE_LADDER.getErrorMessage());
        }
    }

    private void validateDuplicates() {
        int[][] visited = new int[numberOfRows.get()][numberOfPerson.get()];
        for(SideLadder sideLadder : sideLadders) {
            if(visited[sideLadder.getRow()][sideLadder.getPosition().get()] == 1
            || visited[sideLadder.getRow()][sideLadder.getPosition().get() + 1] == 1) {
                throw new IllegalArgumentException(ExceptionMessage.INVALID_SIDE_LADDER.getErrorMessage());
            }
            visited[sideLadder.getRow()][sideLadder.getPosition().get()] = 1;
            visited[sideLadder.getRow()][sideLadder.getPosition().get() + 1] = 1;
        }
    }
    public int getNumberOfRows() {
        return this.numberOfRows.get();
    }

    public int getNumberOfPerson() {
        return this.numberOfPerson.get();
    }

    public List<SideLadder> getSideLadders() {
        return sideLadders;
    }
}
