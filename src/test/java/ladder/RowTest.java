package ladder;

import ladder.wrapper.NaturalNumber;
import ladder.wrapper.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RowTest {
    @Test
    void 참여자_한_명_사다리_이동() {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.of(1);
        Row row = new Row(numberOfPerson);

        //when
        Position position = Position.of(0, numberOfPerson);

        //then
        assertEquals(0, row.move(position).get());
    }

    @Test
    void 참여자_두_명_사다리_열간_이동() {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.of(2);
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.of(0, numberOfPerson));

        //when
        Position position = Position.of(0, numberOfPerson);
        Position resultPosition = row.move(position);
        //then
        assertEquals(1, resultPosition.get());

        //when
        position = position.next();
        resultPosition = row.move(position);
        //then
        assertEquals(0, resultPosition.get());
    }

    // 테스트를 위해 준비할 과정이 없으면 given 생략해도 되는지?
    @Test
    void 사다리_위치_최대값_초과_예외_처리() {
        //when
        // 가능한 사다리 시작 위치는 0 ~ 3
        NaturalNumber numberOfPerson = NaturalNumber.of(4);

        //then
        assertThrows(IllegalArgumentException.class, () -> Position.of(4, numberOfPerson));
    }

    @Test
    void 사다리_위치_최소값_미만_예외_처리() {
        //when
        NaturalNumber numberOfPerson = NaturalNumber.of(4);

        //then
        assertThrows(IllegalArgumentException.class, () -> Position.of(-1, numberOfPerson));
    }

    @Test
    void 사다리_라인_그리기_위치_초과_예외() {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.of(4);
        Row row = new Row(numberOfPerson);

        //when
        Position lineStartPosition = Position.of(3, numberOfPerson);

        //then
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(lineStartPosition));
    }

    @Test
    void 사다리_라인_그리기_위치_미만_예외() {
        //when
        NaturalNumber numberOfPerson = NaturalNumber.of(4);

        //then
        assertThrows(IllegalArgumentException.class, () -> Position.of(-1, numberOfPerson));
    }

    @Test
    void 사다리_라인_그리기_좌측_라인_중복_예외() {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.of(4);
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.of(1, numberOfPerson));

        //when
        Position lineStartPosition = Position.of(2, numberOfPerson);

        //then
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(lineStartPosition));
    }

    @Test
    void 사다리_라인_그리기_우측_라인_중복_예외() {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.of(4);
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.of(1, numberOfPerson));

        //when
        Position lineStartPosition = Position.of(0, numberOfPerson);

        //then
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(lineStartPosition));
    }

    @Test
    void 한_줄_출력하기() {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.of(4);
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.of(1, numberOfPerson));

        //when
        String rowResult = row.printRow();

        //then
        assertEquals("0 1 -1 0 \n", rowResult);
    }
}
