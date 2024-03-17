package ladder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    void 사다리_생성_확인() {
        //given
        NaturalNumber numberOfRow = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(5);

        //when
        Ladder ladder  = new Ladder(numberOfRow, numberOfPerson);

        //then
        assertNotNull(ladder);
    }

    @Test
    void 사다리_시작위치_예외_처리() {
        //given
        NaturalNumber numberOfRow = NaturalNumber.of(1);
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);

        //when
        int nthOfPerson = 3;
        Position position = Position.of(nthOfPerson);

        //then
        assertThrows(IllegalArgumentException.class, () -> ladder.run(position));
    }

    @Test
    void 사다리_결과_확인() {
        //given
        NaturalNumber numberOfRow = NaturalNumber.of(4);
        NaturalNumber numberOfPerson = NaturalNumber.of(4);
        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);

        ladder.drawLine(Position.of(1), Position.of(0));
        ladder.drawLine(Position.of(1), Position.of(2));
        ladder.drawLine(Position.of(2), Position.of(1));


        //when
        int nthOfPerson = 0;
        Position position = Position.of(nthOfPerson);
        int resultPosition = ladder.run(position);
        //then
        assertEquals(2, resultPosition);

        //when
        nthOfPerson = 1;
        position = Position.of(nthOfPerson);
        resultPosition = ladder.run(position);
        //then
        assertEquals(0, resultPosition);

        //when
        nthOfPerson = 2;
        position = Position.of(nthOfPerson);
        resultPosition = ladder.run(position);
        //then
        assertEquals(3, resultPosition);

        //when
        nthOfPerson = 3;
        position = Position.of(nthOfPerson);
        resultPosition = ladder.run(position);
        //then
        assertEquals(1, resultPosition);



    }
}