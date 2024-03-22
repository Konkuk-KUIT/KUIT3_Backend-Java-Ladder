package ladder.ladderCreator;

import ladder.LadderSpec;
import ladder.NaturalNumber;
import ladder.Row;
import ladder.SideLadder;

public class CustomLadderCreator implements LadderCreator {

    private final LadderSpec ladderSpec;

    public CustomLadderCreator(LadderSpec ladderSpec) {
        this.ladderSpec = ladderSpec;
    }

    @Override
    public Row[] create() {
        Row[] rows = new Row[ladderSpec.getNumberOfRows()];
        for(int i = 0; i < ladderSpec.getNumberOfRows(); i++) {
            rows[i] = new Row(NaturalNumber.from(ladderSpec.getNumberOfPerson()));
        }

        for(SideLadder sideLadder : ladderSpec.getSideLadders()) {
            rows[sideLadder.getRow()].drawLine(sideLadder.getPosition());
        }

        return rows;
    }
}
