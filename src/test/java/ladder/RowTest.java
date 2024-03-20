package ladder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RowTest {
    @Test
    void Right_Left_셋트로_그리나() {
        Row row = new Row(NaturalNumber.from(4));
        row.drawLine(Position.initFrom(1, NaturalNumber.from(4)));
        Assertions.assertEquals(row.getNodes()[1], Node.from(Direction.RIGHT));
        Assertions.assertEquals(row.getNodes()[2], Node.from(Direction.LEFT));

    }
//      Refactoring 전 Test입니다.
//    @Test
//    void 참여자_한_명_사다리_이동() {
//        //given
//        int numberOfPerson = 1;
//        Row row = new Row(numberOfPerson);
//
//        //when
//        int position = 0;
//
//        //then
//        assertEquals(0,row.nextPosition(position));
//    }
//
//    @Test
//    void 참여자_두_명_사다리_열간_이동() {
//        //given
//        int numberOfPerson = 2;
//        Row row = new Row(numberOfPerson);
//        row.drawLine(0);
//
//        //when
//        int position = 0;
//        int resultPosition = row.nextPosition(position);
//        //then
//        assertEquals(1,resultPosition);
//
//
//        //when
//        position = 1;
//        resultPosition = row.nextPosition(position);
//        //then
//        assertEquals(0, resultPosition);
//    }
//
//    @Test
//    void 참여자_세_명_사다리_열간_이동() {
//        //given
//        int numberOfPerson = 3;
//        Row row = new Row(numberOfPerson);
//        row.drawLine(0);
//
//        //when
//        int position = 0;
//        int resultPosition = row.nextPosition(position);
//        //then
//        assertEquals(1,resultPosition);
//
//
//        //when
//        position = 1;
//        resultPosition = row.nextPosition(position);
//        //then
//        assertEquals(0, resultPosition);
//
//        //when
//        position = 2;
//        resultPosition = row.nextPosition(position);
//        //then
//        assertEquals(2, resultPosition);
//    }
//
//    @Test
//    void 사다리_사람수_예외_처리() {
//        assertThrows(IllegalArgumentException.class, () -> new Row(0));
//    }
//
//    @Test
//    void 사다리_위치_최대값_초과_예외_처리() {
//        //given
//        int numberOfPerson = 3;
//        Row row = new Row(numberOfPerson);
//
//        //when
//        int position = 3;
//
//        //then
//        assertThrows(IllegalArgumentException.class, () -> row.nextPosition(position));
//    }
//
//    @Test
//    void 사다리_위치_최소값_미만_예외_처리() {
//        //given
//        int numberOfPerson = 3;
//        Row row = new Row(numberOfPerson);
//
//        //when
//        int position = -1;
//
//        //then
//        assertThrows(IllegalArgumentException.class, () -> row.nextPosition(position));
//    }
//
//    @Test
//    void 사다리_라인_그리기_위치_초과_예외() {
//        //given
//        int numberOfPerson = 3;
//        Row row = new Row(numberOfPerson);
//
//        //when
//        int lineStartPosition = 2;
//
//        //then
//        assertThrows(IllegalArgumentException.class, () -> row.drawLine(lineStartPosition));
//    }
//
//    @Test
//    void 사다리_라인_그리기_위치_미만_예외() {
//        //given
//        int numberOfPerson = 3;
//        Row row = new Row(numberOfPerson);
//
//        //when
//        int lineStartPosition = -1;
//
//        //then
//        assertThrows(IllegalArgumentException.class, () -> row.drawLine(lineStartPosition));
//    }
//
//    @Test
//    void 라인_그리기_좌측_라인_중복_예외() {
//        //given
//        int numberOfPerson = 3;
//        Row row = new Row(numberOfPerson);
//        row.drawLine(0);
//
//        //when
//        int lineStartPosition = 1;
//
//        //then
//        assertThrows(IllegalArgumentException.class, () -> row.drawLine(lineStartPosition));
//
//    }
//
//    @Test
//    void 라인_그리기_우측_라인_중복_예외() {
//        //given
//        int numberOfPerson = 3;
//        Row row = new Row(numberOfPerson);
//        row.drawLine(1);
//
//        //when
//        int lineStartPosition = 0;
//
//        //then
//        assertThrows(IllegalArgumentException.class, () -> row.drawLine(lineStartPosition));
//
//    }
//
}