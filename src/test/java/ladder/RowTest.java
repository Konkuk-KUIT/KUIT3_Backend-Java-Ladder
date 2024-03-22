package ladder;

import Numbers.NaturalNum;
import Numbers.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RowTest {

    @Test
    void 참여자_한_명_사다리_이동() {
        //given
        int numberOfPerson = 1;
        NaturalNum one = NaturalNum.of(1);
        Row row = new Row(one);

        //when
        Position position = Position.of(0);

        //then
        assertEquals(0,row.nextPosition(position).get());
    }

    @Test
    void 참여자_두_명_사다리_열간_이동() {
        //given
        //int numberOfPerson = 2;
        NaturalNum numberOfPerson = NaturalNum.of(2);
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.of(0));

        //when
        Position position = Position.of(0);
        int resultPosition = row.nextPosition(position).get();
        //then
        assertEquals(1,resultPosition);


        //when
        position = Position.of(1);
        resultPosition = row.nextPosition(position).get();
        //then
        assertEquals(0, resultPosition);
    }

    @Test
    void 참여자_세_명_사다리_열간_이동() {
        //given
        //int numberOfPerson = 3;
        NaturalNum numberOfPerson = NaturalNum.of(3);
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.of(0));

        //when
        Position position = Position.of(0);
        int resultPosition = row.nextPosition(position).get();
        //then
        assertEquals(1,resultPosition);


        //when
        position = Position.of(1);
        resultPosition = row.nextPosition(position).get();
        //then
        assertEquals(0, resultPosition);

        //when
        position = Position.of(2);
        resultPosition = row.nextPosition(position).get();
        //then
        assertEquals(2, resultPosition);
    }

    @Test
    void 사다리_사람수_예외_처리() {
        assertThrows(IllegalArgumentException.class, () -> new Row(NaturalNum.of(0)));
    }

    @Test
    void 사다리_위치_최대값_초과_예외_처리() {
        //given

        NaturalNum numberOfPerson = NaturalNum.of(3);
        Row row = new Row(numberOfPerson);

        //when
        //int position = 3;
        Position position=Position.of(3);
        //then
        assertThrows(IllegalArgumentException.class, () -> row.nextPosition(position));
    }

    @Test
    void 사다리_위치_최소값_미만_예외_처리() {
        //given
        NaturalNum numberOfPerson = NaturalNum.of(3);
        Row row = new Row(numberOfPerson);

        //when
        //Position position = ;;

        //then
        assertThrows(IllegalArgumentException.class, () -> row.nextPosition(Position.of(-1)));
    }

    @Test
    void 사다리_라인_그리기_위치_초과_예외() {
        //given
        NaturalNum numberOfPerson = NaturalNum.of(3);
        Row row = new Row(numberOfPerson);

        //when
        int lineStartPosition = 2;

        //then
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(Position.of(lineStartPosition)));
    }

    @Test
    void 사다리_라인_그리기_위치_미만_예외() {
        //given
        NaturalNum numberOfPerson = NaturalNum.of(3);
        Row row = new Row(numberOfPerson);

        //when
        int lineStartPosition = -1;

        //then
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(Position.of(lineStartPosition)));
    }

    @Test
    void 라인_그리기_좌측_라인_중복_예외() {
        //given
        NaturalNum numberOfPerson = NaturalNum.of(3);
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
        NaturalNum numberOfPerson = NaturalNum.of(3);
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.of(1));

        //when
        int lineStartPosition = 0;

        //then
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(Position.of(lineStartPosition)));

    }
    @Test
    void 랜덤_라인_그리기_성공() {
        //given
        NaturalNum numberOfPerson = NaturalNum.of(3);
        Row row = new Row(numberOfPerson);


        //when
        boolean result =row.drawRandomLine();

        //then
        row.printRow(null,null);
        assertEquals(true,result);

    }

    @Test
    void 랜덤_라인_그리기_실패() {
        //given
        NaturalNum numberOfPerson = NaturalNum.of(3);
        Row row = new Row(numberOfPerson);


        //when
        for(int i =0;i<10;i++){
            row.drawRandomLine();
        }
        boolean result =row.drawRandomLine();
        row.printRow(null,null);
        //then
        assertEquals(false,result);

    }


}