package ladder.ladderCreator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import ladder.Cordinate;
import ladder.LadderSpec;
import ladder.NaturalNumber;
import ladder.Position;
import ladder.Row;

public class RandomLadderCreator implements LadderCreator {

    private final NaturalNumber numberOfRow;

    public RandomLadderCreator(NaturalNumber numberOfRow, NaturalNumber numberOfPerson) {
        this.numberOfRow = numberOfRow;
        this.numberOfPerson = numberOfPerson;
    }

    private final NaturalNumber numberOfPerson;
    Random rand = new Random();


    public LadderSpec createLadderSpec() {
        try {
            return new LadderSpec(numberOfRow, numberOfPerson, createSideLadders());
        } catch (IllegalArgumentException e) {
            return createLadderSpec();
        }
    }

    private List<Cordinate> createSideLadders() throws IllegalArgumentException {
        int numberToIter = (int) (numberOfRow.get() * numberOfPerson.get() * 0.3);
        List<Cordinate> sideLadders = new ArrayList<>();
        for(int i = 0; i < numberToIter; i++) {
            int randRow = rand.nextInt(numberOfRow.get());
            int randPerson = rand.nextInt(numberOfPerson.get() - 1);    // 맨 오른쪽 줄에는 생성될수 없음
            sideLadders.add(Cordinate.of(randRow, randPerson));
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

        for(Cordinate sideLadder : ladderSpec.getSideLadders()) {
            rows[sideLadder.getRowIndex()].drawLine(sideLadder.getColIndex());
        }

        return rows;
    }
}
