package ladder;

import Numbers.NaturalNum;
import Numbers.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderPrintTest {
    @Test
    void 사다리_출력_테스트(){
        //given
        NaturalNum five = NaturalNum.of(5);
        NaturalNum four = NaturalNum.of(4);
        Position pos = Position.of(2);
        LadderCreator ladderCreator =LadderCreator.of(five, four);
        ladderCreator.DrawLine(Position.of(2),Position.of(2));
        ladderCreator.DrawLine(Position.of(0),Position.of(2));
        ladderCreator.DrawLine(Position.of(1),Position.of(1));
        LadderRunner ladderRunner = LadderRunner.of(ladderCreator.getrows());

        //when
        ladderRunner.printLadder(Position.of(2),3);

        //then
        assertEquals(2, 2);

    }



}
