package ladder.creator;

import ladder.Ladder;
import ladder.wrapper.NaturalNumber;
import ladder.wrapper.Position;

public class FixedLadderCreator implements LadderCreator {
    @Override
    public Ladder createLadder(NaturalNumber numberOfRows, NaturalNumber numberOfPerson) {
        Ladder ladder = new Ladder(numberOfRows, numberOfPerson);

        makeFixedLines(ladder, numberOfRows, numberOfPerson);

        return ladder;
    }

    // 사용자와 상호작용한다면, 사용자 입력을 받아 생성
    private void makeFixedLines(Ladder ladder, NaturalNumber numberOfRows, NaturalNumber numberOfPerson) {
        ladder.drawLine(Position.of(0, numberOfRows), Position.of(0, numberOfPerson));
        ladder.drawLine(Position.of(1, numberOfRows), Position.of(1, numberOfPerson));
        ladder.drawLine(Position.of(2, numberOfRows), Position.of(0, numberOfPerson));
        ladder.drawLine(Position.of(2, numberOfRows), Position.of(2, numberOfPerson));
    }
}
