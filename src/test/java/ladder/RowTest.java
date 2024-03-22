package ladder;

import ladder.domain.NaturalNumber;
import ladder.domain.Position;
import ladder.domain.Row;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class RowTest {

    @Test
    void 참여자_한_명_사다리_이동() {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.of(1);
        Row row = new Row(numberOfPerson);

        //when
        int nthOfPerson = 0;
        Position position = Position.of(nthOfPerson);

        //then
        assertEquals(0, row.nextPosition(position).getValue());
    }

    @Test
    void 참여자_두_명_사다리_열간_이동() {
        //given
        Naturalnumber numberOfPerson = NaturalNumber.of(2);
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.of(0));

        //given
        int nthOfPerson = 0;
        Position position = Position.of(nthOfPerson);

        //then
        assertEquals(1, row.nextPosition(position).getValue());

        //given
        nthOfPerson = 1;
        position = Position.of(nthOfPerson);

        //then
        assertEquals(0, row.nextPosition(position).getValue());
    }

    @Test
    void 참여자_세_명_사다리_열간_이동() {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.of(0));

        //when
        int nthOfPerson = 0;
        Position position = Position.of(nthOfPerson);
        //then
        assertEquals(1, row.nextPosition(position).getValue());


        //when
        nthOfPerson = 1;
        position = Position.of(nthOfPerson);
        //then
        assertEquals(0, row.nextPosition(position).getValue());


        //when
        nthOfPerson = 2;
        position = Position.of(nthOfPerson);
        //then
        assertEquals(2, row.nextPosition(position).getValue());
    }

    @Test
    void 사다리_사람수_예외_처리() {
        assertThrows(IllegalArgumentException.class, () -> new Row(NaturalNumber.of(0)));
    }

    @Test
    void 사다리_위치_최대값_초과_예외_처리() {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        Row row = new Row(numberOfPerson);

        //when
        int nthOfPerson = 3;
        Position position = Position.of(nthOfPerson);

        //then
        assertThrows(IllegalArgumentException.class, () -> row.nextPosition(position));
    }

    @Test
    void 사다리_위치_최소값_미만_예외_처리() {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        Row row = new Row(numberOfPerson);

        //when
        int position = -1;

        //then
        assertThrows(IllegalArgumentException.class, () -> row.nextPosition(Position.of(position)));
    }

    @Test
    void 사다리_라인_그리기_위치_초과_예외() {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        Row row = new Row(numberOfPerson);

        //when
        int position = 2;

        //then
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(Position.of(position)));
    }

    @Test
    void 사다리_라인_그리기_위치_미만_예외() {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        Row row = new Row(numberOfPerson);

        //when
        int position = -1;

        //then
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(Position.of(position)));
    }

    @Test
    void 라인_그리기_좌측_라인_중복_예외() {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.of(0));

        //when
        int lineStartPosition = 1;

        //then
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(Position.of(lineStartPosition)));

    }

    @Test
    void 라인_그리기_우측_라인_중복_예외() {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.of(1));

        //when
        int lineStartPosition = 0;

        //then
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(Position.of(lineStartPosition)));

    }

}