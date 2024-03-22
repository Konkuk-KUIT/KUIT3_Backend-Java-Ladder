package ladder;

import model.NaturalNumber;
import model.Node;
import model.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RowTest {

    @Test
    void 참여자_한_명_사다리_이동() {
        //given
        NaturalNumber numberOfPerson = new NaturalNumber(1);
        Row row = new Row(numberOfPerson);

        //when
        Position position = Position.of(0);

        //then
        assertEquals(0,row.nextPosition(position).getPosition());
    }

    @Test
    void 참여자_두_명_사다리_열간_이동() {
        //given
        NaturalNumber numberOfPerson = new NaturalNumber(2);
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.of(0));
        //when
        Position position = Position.of(0);
        Position resultPosition = row.nextPosition(position);
        //then
        assertEquals(1,resultPosition.getPosition());


        //when
        resultPosition = row.nextPosition(Position.of(1));
        //then
        assertEquals(0, resultPosition.getPosition());
    }

    @Test
    void 참여자_세_명_사다리_열간_이동() {
        //given
        NaturalNumber numberOfPerson = new NaturalNumber(3);
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.of(0));

        //when
        int position = 0;
        Position resultPosition = row.nextPosition(Position.of(position));
        //then
        assertEquals(1,resultPosition.getPosition());


        //when
        position = 1;
        resultPosition = row.nextPosition(Position.of(position));
        //then
        assertEquals(0, resultPosition.getPosition());

        //when
        position = 2;
        resultPosition = row.nextPosition(Position.of(position));
        //then
        assertEquals(2, resultPosition.getPosition());
    }

    @Test
    void 사다리_사람수_예외_처리() {
        assertThrows(IllegalArgumentException.class, () -> new Row(NaturalNumber.of(0)));
    }

    @Test
    void 사다리_위치_최대값_초과_예외_처리() {
        //given

        Row row = new Row(NaturalNumber.of(3));

        //when
        int position = 3;

        //then
        assertThrows(IllegalArgumentException.class, () -> row.nextPosition(Position.of(position)));
    }

    @Test
    void 사다리_위치_최소값_미만_예외_처리() {
        //given
        Row row = new Row(NaturalNumber.of(3));

        //when
        int position = -1;

        //then
        assertThrows(IllegalArgumentException.class, () -> row.nextPosition(Position.of(position)));
    }

    @Test
    void 사다리_라인_그리기_위치_초과_예외() {
        //given
        Row row = new Row(NaturalNumber.of(3));

        //when
        int lineStartPosition = 2;

        //then
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(Position.of(lineStartPosition)));
    }

    @Test
    void 사다리_라인_그리기_위치_미만_예외() {
        //given
        Row row = new Row(NaturalNumber.of(3));

        //when
        int lineStartPosition = -1;

        //then
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(Position.of(lineStartPosition)));
    }

    @Test
    void 라인_그리기_좌측_라인_중복_예외() {
        //given
        Row row = new Row(NaturalNumber.of(3));
        row.drawLine(Position.of(0));

        //when
        int lineStartPosition = 1;

        //then
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(Position.of(lineStartPosition)));

    }

    @Test
    void 라인_그리기_우측_라인_중복_예외() {
        //given

        Row row = new Row(NaturalNumber.of(3));
        row.drawLine(Position.of(1));

        //when
        int lineStartPosition = 0;

        //then
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(Position.of(lineStartPosition)));

    }

}