package ladder.ladderCreator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import ladder.wrapper.Coordinate;
import ladder.wrapper.LadderSpec;
import ladder.wrapper.NaturalNumber;
import ladder.wrapper.Row;

public class RandomLadderCreator implements LadderCreator {

    private final NaturalNumber numberOfRow;

    private final NaturalNumber numberOfPerson;
    private final Random rand = new Random();

    public RandomLadderCreator(NaturalNumber numberOfRow, NaturalNumber numberOfPerson) {
        this.numberOfRow = numberOfRow;
        this.numberOfPerson = numberOfPerson;
    }

    public LadderSpec createLadderSpec() {
        try {
            return new LadderSpec(numberOfRow, numberOfPerson, createSideLadders());
        } catch (IllegalArgumentException e) {
            return createLadderSpec();
        }
    }

    private List<Coordinate> createSideLadders() throws IllegalArgumentException {
        int numberToIter = (int) (numberOfRow.get() * numberOfPerson.get() * 0.3);
        List<Coordinate> sideLadders = new ArrayList<>();
        for(int i = 0; i < numberToIter; i++) {
            int randRow = rand.nextInt(numberOfRow.get());
            int randPerson = rand.nextInt(numberOfPerson.get() - 1);    // 맨 오른쪽 줄에는 생성될수 없음
            sideLadders.add(Coordinate.of(randRow, randPerson));
        }

        return sideLadders;
    }

    @Override
    public Row[] create() {
        LadderSpec ladderSpec = createLadderSpec();
        Row[] rows = new Row[numberOfRow.get()];
        for(int i = 0; i < numberOfRow.get(); i++) {
            rows[i] = new Row(NaturalNumber.from(ladderSpec.getNumberOfPerson()));
        }

        for(Coordinate sideLadder : ladderSpec.getSideLadders()) {
            rows[sideLadder.getRowIndex()].drawLine(sideLadder.getColIndex());
        }

        return rows;
    }
}
