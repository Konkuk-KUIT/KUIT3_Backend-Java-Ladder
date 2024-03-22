package ladder;

import ladder.creater.LadderCreator;
import ladder.application.LadderGame;
import ladder.core.NaturalNumber;
import ladder.position.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderGameTest {

    @Test
    void 사다리_생성_확인() {
        //given
        NaturalNumber numberOfRow = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(5);

        //when
        LadderCreator ladderCreator = new LadderCreator(numberOfRow, numberOfPerson);

        //then
        assertNotNull(ladderCreator);
    }

    @Test
    void 사다리_시작위치_예외_처리() {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        NaturalNumber numberOfRow = NaturalNumber.of(1);
        LadderCreator ladderCreator = new LadderCreator(numberOfRow, numberOfPerson);
        LadderGame ladderGame = new LadderGame(ladderCreator);

        //when
        int nthOfPerson = 3;
        Position position = Position.of(nthOfPerson);

        //then
        assertThrows(IllegalArgumentException.class, ()->ladderGame.run(position));
    }

    @Test
    void 사다리_결과_확인() {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.of(4);
        NaturalNumber numberOfRow = NaturalNumber.of(4);

        LadderCreator ladderCreator = new LadderCreator(numberOfRow, numberOfPerson);
        LadderGame ladderGame = new LadderGame(ladderCreator);

        ladderCreator.drawLine(Position.of(1), Position.of(0));
        ladderCreator.drawLine(Position.of(1), Position.of(2));
        ladderCreator.drawLine(Position.of(2), Position.of(1));


        //when
        int position = 0;
        int resultPosition = ladderGame.run(Position.of(position));
        //then
        assertEquals(2, resultPosition);

        //when
        position = 1;
        resultPosition = ladderGame.run(Position.of(position));
        //then
        assertEquals(0, resultPosition);

        //when
        position = 2;
        resultPosition = ladderGame.run(Position.of(position));
        //then
        assertEquals(3, resultPosition);

        //when
        position = 3;
        resultPosition = ladderGame.run(Position.of(position));
        //then
        assertEquals(1, resultPosition);



    }
}