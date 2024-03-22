package ladder.ladderCreator;

import ladder.wrapper.Coordinate;
import ladder.wrapper.LadderSpec;
import ladder.wrapper.NaturalNumber;
import ladder.wrapper.Row;

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

        for(Coordinate sideLadder : ladderSpec.getSideLadders()) {
            rows[sideLadder.getRowIndex()].drawLine(sideLadder.getColIndex());  // 얘때매 Position반환하는거 만들어야 되냐? row에서 drawLine overring?
        }

        return rows;
    }
}
