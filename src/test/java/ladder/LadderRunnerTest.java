package ladder;

import java.util.List;
import ladder.ladderCreator.CustomLadderCreator;
import ladder.ladderCreator.LadderCreator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LadderRunnerTest {
    class MockLadderCreator implements LadderCreator{

        @Override
        public Row[] create() {
            int totalPlayer = 5;
            Row[] rows = new Row[4];    // 높이는 4
            for(int i = 0; i < 4; i++) {
                rows[i] = new Row(NaturalNumber.from(totalPlayer));
            }

            rows[0].drawLine(Position.initOf(0, NaturalNumber.from(5)));
            rows[1].drawLine(Position.initOf(1, NaturalNumber.from(5)));

            return rows;
        }
    }

    @Test
    void Mock_사다리_타기_시험() {
        LadderRunner ladderRunner = new LadderRunner(new MockLadderCreator().create());
        Position pos = ladderRunner.run(Position.initOf(0, NaturalNumber.from(5)));
        Assertions.assertEquals(pos.get(), 2);
    }

    @Test
    void 사다리_타기_시험_with_custom_creator() {
        LadderCreator ladderCreator = new CustomLadderCreator(
                new LadderSpec(
                        NaturalNumber.from(4), NaturalNumber.from(5),
                        List.of(new SideLadder(0, Position.initOf(0, NaturalNumber.from(5)))
                                , new SideLadder(1, Position.initOf(1, NaturalNumber.from(5))))
                )
        );
        Row[] rows = ladderCreator.create();

        LadderRunner ladderRunner = new LadderRunner(rows);
        Position pos = ladderRunner.run(Position.initOf(0, NaturalNumber.from(5)));
        Assertions.assertEquals(2, pos.get());
        Position pos2 = ladderRunner.run(Position.initOf(1, NaturalNumber.from(5)));
        Assertions.assertEquals(0, pos2.get());
        Position pos3 = ladderRunner.run(Position.initOf(2, NaturalNumber.from(5)));
        Assertions.assertEquals(1, pos3.get());
    }
}
