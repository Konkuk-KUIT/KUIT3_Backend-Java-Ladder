package ladder;

import LadderCreator.LadderCreator;
import model.LadderSize;
import model.NaturalNumber;
import model.Position;
import LadderCreator.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderCreatorTest {
    @Test
    void 사다리_출력_확인() {
        //given
        LadderCreator ladder = new CustomLadderCreator(LadderSize.of(NaturalNumber.of(5),NaturalNumber.of(4)));
        ladder.drawLine(Position.of(1),Position.of(0));
        ladder.drawLine(Position.of(1),Position.of(2));
        ladder.drawLine(Position.of(2),Position.of(1));
        LadderGame ladderGame = new LadderGame(ladder);

        //when
        Position resultPosition = ladderGame.run_game(Position.of(0));
        //then
        assertEquals(2, resultPosition.getPosition());

        //when

//        resultPosition = ladder.run(position);
//        //then
//        assertEquals(1, resultPosition);



    }
}
