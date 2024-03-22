package ladder.creator;

import ladder.data.Row;
import type.NaturalNumber;

public class SetUpLadderCreator implements LadderCreator {

    NaturalNumber numberOfRows;
    NaturalNumber numberOfPersons;

    public SetUpLadderCreator(NaturalNumber numberOfRows, NaturalNumber numberOfPersons) {
        this.numberOfRows = numberOfRows;
        this.numberOfPersons = numberOfPersons;
    }

    @Override
    public Row[] createLadder() {
        return null;
    }

}
