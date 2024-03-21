package ladder;

import ladder.creator.LadderCreator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderGameTest {

    @Test
    void 사다리_생성_확인() {
        //given
        NaturalNumber numberOfRow = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(5);
        LadderSize ladderSize = LadderSize.of(numberOfRow, numberOfPerson);

        //when
        LadderCreator ladderCreator  = new LadderCreator(ladderSize);

        //then
        assertNotNull(ladderCreator);
    }

    @Test
    void 사다리_시작위치_예외_처리() {
        //given
        NaturalNumber numberOfRow = NaturalNumber.of(1);
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        LadderSize ladderSize = LadderSize.of(numberOfRow, numberOfPerson);
        LadderCreator ladderCreator  = new LadderCreator(ladderSize);
        LadderGame ladderGame = new LadderGame(ladderCreator);

        //when
        int nthOfPerson = 3;
        Position position = Position.of(nthOfPerson);

        //then
        assertThrows(IllegalArgumentException.class, () -> ladderGame.run(position));
    }

    @Test
    void 사다리_결과_확인() {
        //given
        NaturalNumber numberOfRow = NaturalNumber.of(4);
        NaturalNumber numberOfPerson = NaturalNumber.of(4);
        LadderSize ladderSize = LadderSize.of(numberOfRow, numberOfPerson);
        LadderCreator ladderCreator  = new LadderCreator(ladderSize);

        ladderCreator.drawLine(Position.of(1), Position.of(0));
        ladderCreator.drawLine(Position.of(1), Position.of(2));
        ladderCreator.drawLine(Position.of(2), Position.of(1));

        LadderGame ladderGame = new LadderGame(ladderCreator);


        //when
        int nthOfPerson = 0;
        Position position = Position.of(nthOfPerson);
        int resultPosition = ladderGame.run(position);
        //then
        assertEquals(2, resultPosition);

        //when
        nthOfPerson = 1;
        position = Position.of(nthOfPerson);
        resultPosition = ladderGame.run(position);
        //then
        assertEquals(0, resultPosition);

        //when
        nthOfPerson = 2;
        position = Position.of(nthOfPerson);
        resultPosition = ladderGame.run(position);
        //then
        assertEquals(3, resultPosition);

        //when
        nthOfPerson = 3;
        position = Position.of(nthOfPerson);
        resultPosition = ladderGame.run(position);
        //then
        assertEquals(1, resultPosition);



    }
}