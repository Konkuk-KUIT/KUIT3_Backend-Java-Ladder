package ladder.ladderCreator;

import ladder.Ladder;
import ladder.LadderSpec;
import ladder.NaturalNumber;
import ladder.Row;
import ladder.SideLadder;

public class CustomLadderCreator implements LadderCreator {

    private final LadderSpec ladderspec;

    public CustomLadderCreator(LadderSpec ladderSpec) {
        this.ladderspec = ladderSpec;
    }

    @Override
    public Row[] create() {
        Row[] rows = new Row[ladderspec.getNumberOfRows()];
        for(int i = 0; i < ladderspec.getNumberOfRows(); i++) {
            rows[i] = new Row(NaturalNumber.from(ladderspec.getNumberOfPerson()));
        }

        for(SideLadder sideLadder : ladderspec.getSideLadders()) {
            rows[sideLadder.getRow()].drawLine(sideLadder.getPosition());
        }

        return rows;
    }
}
