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
        int numberOfPerson = 1;
        Row row = new Row(NaturalNumber.of(numberOfPerson));

        //when
        //int position = 0;
        Position position = Position.of(0);

        //then
        assertEquals(0, row.nextPosition(position).get());
    }

    @Test
    void 참여자_두_명_사다리_열간_이동() {
        //given
        int numberOfPerson = 2;
        Row row = new Row(NaturalNumber.of(numberOfPerson));
        row.drawLine(Position.of(0));

        //when
        Position position = Position.of(0);
        Position resultPosition = row.nextPosition(position);
        //then
        assertEquals(1,resultPosition.get());


        //when
        position = Position.of(1);
        resultPosition = row.nextPosition(position);
        //then
        assertEquals(0, resultPosition.get());
    }

    @Test
    void 참여자_세_명_사다리_열간_이동() {
        //given
        int numberOfPerson = 3;
        Row row = new Row(NaturalNumber.of(numberOfPerson));
        row.drawLine(Position.of(0));

        //when
        Position position = Position.of(0);
        Position resultPosition = row.nextPosition(position);
        //then
        assertEquals(1,resultPosition.get());


        //when
        position = Position.of(1);
        resultPosition = row.nextPosition(position);
        //then
        assertEquals(0, resultPosition.get());

        //when
        position = Position.of(2);
        resultPosition = row.nextPosition(position);
        //then
        assertEquals(2, resultPosition.get());
    }

    @Test
    void 사다리_사람수_예외_처리() {
        assertThrows(IllegalArgumentException.class, () -> new Row(NaturalNumber.of(0)));
    }

    @Test
    void 사다리_위치_최대값_초과_예외_처리() {
        //given
        int numberOfPerson = 3;
        Row row = new Row(NaturalNumber.of(numberOfPerson));

        //when
        int position = 3;

        //then
        assertThrows(IllegalArgumentException.class, () -> row.nextPosition(Position.of(position)));
    }

    @Test
    void 사다리_위치_최소값_미만_예외_처리() {
        //given
        int numberOfPerson = 3;
        Row row = new Row(NaturalNumber.of(numberOfPerson));

        //when
        int position = -1;

        //then
        assertThrows(IllegalArgumentException.class, () -> row.nextPosition(Position.of(position)));
    }

    @Test
    void 사다리_라인_그리기_위치_초과_예외() {
        //given
        int numberOfPerson = 3;
        Row row = new Row(NaturalNumber.of(numberOfPerson));

        //when
        Position lineStartPosition = Position.of(2);

        //then
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(lineStartPosition));
    }

    @Test
    void 사다리_라인_그리기_위치_미만_예외() {
        //given
        int numberOfPerson = 3;
        Row row = new Row(NaturalNumber.of(numberOfPerson));

        //when
        int lineStartPosition = -1;

        //then
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(Position.of(lineStartPosition)));
    }

    @Test
    void 라인_그리기_좌측_라인_중복_예외() {
        //given
        int numberOfPerson = 3;
        Row row = new Row(NaturalNumber.of(numberOfPerson));
        row.drawLine(Position.of(0));

        //when
        Position lineStartPosition = Position.of(1);

        //then
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(lineStartPosition));

    }

    @Test
    void 라인_그리기_우측_라인_중복_예외() {
        //given
        int numberOfPerson = 3;
        Row row = new Row(NaturalNumber.of(numberOfPerson));
        row.drawLine(Position.of(1));

        //when
        Position lineStartPosition = Position.of(0);

        //then
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(lineStartPosition));

    }

}