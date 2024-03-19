package game;

import game.field.Field;
import game.field.Ladder;
import game.pipe.util.CustomException;
import game.pipe.util.ErrorCode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    void 사다리_생성_확인() {
        //given
        int numberOfRows = 3;
        int numberOfPerson = 5;

        //when
        Field field = new Ladder(numberOfRows, numberOfPerson);

        //then
        assertNotNull(field);
    }

    @Test
    void 사다리_시작위치_예외_처리() {
        //given
        int numberOfPerson = 3;
        int numberOfRows = 1;
        Field field = new Ladder(numberOfRows, numberOfPerson);

        //when
        int position = 3;

        //then
        Throwable exception = assertThrows(RuntimeException.class, () -> field.run(position));
        assertTrue(exception instanceof CustomException);
        assertSame(ErrorCode.INVALID_POSITION.getMessage(),exception.getMessage());
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
        int position = 0;
        int resultPosition = ladder.run(position);
        //then
        assertEquals(2, resultPosition);

        //when
        position = 1;
        resultPosition = ladder.run(position);
        //then
        assertEquals(0, resultPosition);

        //when
        position = 2;
        resultPosition = ladder.run(position);
        //then
        assertEquals(3, resultPosition);

        //when
        position = 3;
        resultPosition = ladder.run(position);
        //then
        assertEquals(1, resultPosition);



    }
}