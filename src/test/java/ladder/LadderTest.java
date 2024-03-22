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
        Position position = Position.at(3);

        //then
        assertThrows(IllegalArgumentException.class, () -> ladder.run(position));
    }

    @Test
    void 사다리_결과_확인() {
        //given
        int numberOfPerson = 4;
        int numberOfRows = 4;
        Ladder ladder = new Ladder(numberOfRows, numberOfPerson);
        ladder.drawLine(1,0);
        ladder.drawLine(1,2);
        ladder.drawLine(2,1);


        //when
        Position position = Position.at(0);
        Position resultPosition = ladder.run(position);
        //then
        assertEquals(2, resultPosition.getColNum());

        //when
        position = Position.at(1);
        resultPosition = ladder.run(position);
        //then
        assertEquals(0, resultPosition.getColNum());

        //when
        position = Position.at(2);
        resultPosition = ladder.run(position);
        //then
        assertEquals(3, resultPosition.getColNum());

        //when
        position = Position.at(3);
        resultPosition = ladder.run(position);
        //then
        assertEquals(1, resultPosition.getColNum());
    }
}