package ladder;

import LadderCreator.*;
import model.LadderSize;
import model.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    void 사다리_생성_확인() {
        //given
        //when
        LadderCreator ladder  = new CustomLadderCreator(LadderSize.InttoLadderSize(3,5));

        //then
        assertNotNull(ladder);
    }

    @Test
    void 사다리_시작위치_예외_처리() {
        //given
        LadderCreator ladder = new CustomLadderCreator(LadderSize.InttoLadderSize(3,1));
        LadderGame ladderGame = new LadderGame(ladder);
        //when
        int position = 3;

        //then
        assertThrows(IllegalArgumentException.class, () -> ladderGame.run_game(Position.of(3)));
    }

    @Test
    void 사다리_결과_확인() {
        //given
        LadderCreator ladder = new CustomLadderCreator(LadderSize.InttoLadderSize(4,4));
        ladder.drawLine(Position.of(1),Position.of(0));
        ladder.drawLine(Position.of(1),Position.of(2));
        ladder.drawLine(Position.of(2),Position.of(1));
        LadderGame ladderGame = new LadderGame(ladder);

        //when
        Position resultPosition = ladderGame.run_game(Position.of(0));
        //then
        assertEquals(2, resultPosition.getPosition());

        //when
        resultPosition = ladderGame.run_game(Position.of(1));
        //then
        assertEquals(0, resultPosition.getPosition());

        //when

        resultPosition = ladderGame.run_game(Position.of(2));
        //then
        assertEquals(3, resultPosition.getPosition());

        //when

//        resultPosition = ladder.run(position);
//        //then
//        assertEquals(1, resultPosition);



    }

}