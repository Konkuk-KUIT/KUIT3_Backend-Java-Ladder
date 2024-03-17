package ladder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    void 사다리_생성_확인() {
        //given
        int numberOfRows = 3;
        int numberOfPerson = 5;

        //when
        Ladder ladder  = new Ladder(numberOfRows, numberOfPerson);

        //then
        assertNotNull(ladder);
    }

    @Test
    void 사다리_시작위치_예외_처리() {
        //given
        int numberOfPerson = 3;
        int numberOfRows = 1;
        Ladder ladder = new Ladder(numberOfRows, numberOfPerson);

        //when
        int nthOfPerson = 3;
        Position position = Position.of(nthOfPerson);

        //then
        assertThrows(IllegalArgumentException.class, () -> ladder.run(position));
    }

    @Test
    void 사다리_결과_확인() {
        //given
        int numberOfPerson = 4;
        int numberOfRows = 4;
        Ladder ladder = new Ladder(numberOfRows, numberOfPerson);
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