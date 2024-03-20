package ladder;

import java.util.List;
import ladder.ladderCreator.CustomLadderCreator;
import ladder.ladderCreator.LadderCreator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LadderRunnerTest {
//    class MockLadderCreator implements LadderCreator{
//
//        @Override
//        public Row[] create() {
//            int totalPlayer = 5;
//            Row[] rows = new Row[4];    // 높이는 4
//            for(int i = 0; i < 4; i++) {
//                rows[i] = new Row(NaturalNumber.from(totalPlayer));
//            }
//
//            rows[0].drawLine(Position.initFrom(0, NaturalNumber.from(5)));
//            rows[1].drawLine(Position.initFrom(1, NaturalNumber.from(5)));
//
//            return rows;
//        }
//    }
//
//    @Test
//    void 사다리_타기_시험() {
//        LadderRunner ladderRunner = new LadderRunner(new MockLadderCreator().create());
//        Position pos = ladderRunner.run(Position.initFrom(0, NaturalNumber.from(5)));
//        Assertions.assertEquals(pos.get(), 2);
//    }

    @Test
    void 사다리_타기_시험_with_custom_creator() {
        LadderCreator ladderCreator = new CustomLadderCreator(
                new LadderSpec(
                        NaturalNumber.from(4), NaturalNumber.from(5),
                        List.of(new SideLadder(0, Position.initFrom(0, NaturalNumber.from(5)))
                                , new SideLadder(1, Position.initFrom(1, NaturalNumber.from(5))))
                )
        );
        Row[] rows = ladderCreator.create();

        for(Row row : rows) {   // TODO: 얘도 지워라 직접 출려해보자
            for(Node node : row.getNodes()) {
                System.out.print(node + " ");
            }
            System.out.println();
        }

        LadderRunner ladderRunner = new LadderRunner(rows);
        Position pos = ladderRunner.run(Position.initFrom(0, NaturalNumber.from(5)));
        Assertions.assertEquals(2, pos.get());
        Position pos2 = ladderRunner.run(Position.initFrom(1, NaturalNumber.from(5)));
        Assertions.assertEquals(0, pos2.get());
        Position pos3 = ladderRunner.run(Position.initFrom(2, NaturalNumber.from(5)));
        Assertions.assertEquals(1, pos3.get());
    }
}
