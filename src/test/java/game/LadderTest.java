package game;

import game.exception.CustomException;
import game.exception.ErrorCode;
import game.field.Field;
import game.field.Ladder;
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
    void 사다리_시작위치_예외_처리_row() {
        //given
        int numberOfPerson = 3;
        int numberOfRows = 1;
        Field field = new Ladder(numberOfRows, numberOfPerson);

        //when
        int row = 3;
        int col = 2;

        //then
        Throwable exception = assertThrows(RuntimeException.class, () -> field.run(row, col));
        assertTrue(exception instanceof CustomException);
        assertSame(ErrorCode.INVALID_POSITION.getMessage(), exception.getMessage());
    }

    @Test
    void 사다리_시작위치_예외_처리_col() {
        //given
        int numberOfPerson = 3;
        int numberOfRows = 1;
        Field field = new Ladder(numberOfRows, numberOfPerson);

        //when
        int row = 2;
        int col = 3;

        //then
        Throwable exception = assertThrows(RuntimeException.class, () -> field.run(row, col));
        assertTrue(exception instanceof CustomException);
        assertSame(ErrorCode.INVALID_POSITION.getMessage(), exception.getMessage());

    }

    @Test
    void 사다리_결과_확인() {
        //given
        int numberOfPerson = 4;
        int numberOfRows = 4;
        Ladder ladder = new Ladder(numberOfRows, numberOfPerson);
        ladder.drawLine(1, 0);
        ladder.drawLine(1, 2);
        ladder.drawLine(2, 1);


        //when
        int row = 0;
        int col = 0;

        int resultPosition = ladder.run(row,col);
        //then
        assertEquals(2, resultPosition);

        //when
        row = 0;
        col = 1;

        resultPosition = ladder.run(row,col);
        //then
        assertEquals(0, resultPosition);

        //when
        row = 0;
        col = 2;
        resultPosition = ladder.run(row,col);
        //then
        assertEquals(3, resultPosition);

        //when
        row = 0;
        col = 3;
        resultPosition = ladder.run(row,col);
        //then
        assertEquals(1, resultPosition);
    }

    @Test
    void 사다리_출력_확인(){
        //given
        int numberOfPerson = 4;
        int numberOfRows = 4;
        Ladder ladder = new Ladder(numberOfRows, numberOfPerson);
        ladder.drawLine(1, 0);
        ladder.drawLine(1, 2);
        ladder.drawLine(2, 1);
        //when
        int row = 0;
        int col = 0;


        //then
        int resultPosition = ladder.runWithPrint(row,col);
        assertEquals(resultPosition,2);
    }
}