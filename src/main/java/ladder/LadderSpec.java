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
    }

    private void validate() {
        for(SideLadder sideLadder : this.sideLadders) {
            validateOutOfBound(sideLadder);
        }
    }

    private void validateOutOfBound(SideLadder sideLadder) {
        if(sideLadder.getRow() >= numberOfRows.get() || sideLadder.getPosition().get() >= numberOfPerson.get()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_SIDE_LADDER.getErrorMessage());
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
