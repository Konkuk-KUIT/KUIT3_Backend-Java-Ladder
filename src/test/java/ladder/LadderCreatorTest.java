package ladder;

import java.util.List;
import ladder.ladderCreator.CustomLadderCreator;
import org.junit.jupiter.api.Test;

public class LadderCreatorTest {
    @Test
    void 제대로_그리니() {    // 그림으로 체크 했을 떄 ㅇㅇ
        CustomLadderCreator customLadderCreator = new CustomLadderCreator(new LadderSpec(
                NaturalNumber.from(4), NaturalNumber.from(5),
                List.of(new SideLadder(0, Position.initOf(0, NaturalNumber.from(5)))
                        , new SideLadder(1, Position.initOf(1, NaturalNumber.from(5))))
        ));

        Row[] rows = customLadderCreator.create();

        for(Row row : rows) {
            for(Node node : row.getNodes()) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }
}
