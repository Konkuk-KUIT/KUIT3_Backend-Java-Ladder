package ladder;

import ladder.model.LadderPosition;
import ladder.model.Position;
import ladder.model.Row;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RowTest {

    @Test
    void 참여자_한_명_사다리_이동() {
        //given
        int numberOfPerson = 1;
        Row row = new Row(numberOfPerson);

        //when
        Position position = new Position(0);

        //then
        assertEquals(0,row.nextPosition(position).getPosition());
    }

    @Test
    void 참여자_두_명_사다리_열간_이동() {
        //given
        int numberOfPerson = 2;
        Row row = new Row(numberOfPerson);
        Position position1 = new Position(0);
        row.drawLine(position1);

        //when
        Position position = new Position(0);
        Position resultPosition = row.nextPosition(position);
        //then
        assertEquals(1,resultPosition.getPosition());


        //when
        position = new Position(1);
        resultPosition = row.nextPosition(position);
        //then
        assertEquals(0, resultPosition.getPosition());
    }

    @Test
    void 참여자_세_명_사다리_열간_이동() {
        //given
        int numberOfPerson = 3;
        Row row = new Row(numberOfPerson);
        Position position1 = new Position(0);
        row.drawLine(position1);

        //when
        Position position = new Position(0);
        Position resultPosition = row.nextPosition(position);
        //then
        assertEquals(1,resultPosition.getPosition());


        //when
        position = new Position(1);
        resultPosition = row.nextPosition(position);
        //then
        assertEquals(0, resultPosition.getPosition());

        //when
        position = new Position(2);
        resultPosition = row.nextPosition(position);
        //then
        assertEquals(2, resultPosition.getPosition());
    }

//    @Test
//    void 사다리_사람수_예외_처리() {
//        assertThrows(IllegalArgumentException.class, () -> new Row(0));
//    }

    @Test
    void 사다리_위치_최대값_초과_예외_처리() {
        //given
        int numberOfPerson = 3;
        Row row = new Row(numberOfPerson);

        //when
        Position position = new Position(3);

        //then
        assertThrows(IllegalArgumentException.class, () -> row.nextPosition(position));
    }

    @Test
    void 사다리_위치_최소값_미만_예외_처리() {
        //given
        int numberOfPerson = 3;
        Row row = new Row(numberOfPerson);

        //when
        Position position = new Position(-1);

        //then
        assertThrows(IllegalArgumentException.class, () -> row.nextPosition(position));
    }

    @Test
    void 사다리_라인_그리기_위치_초과_예외() {
        //given
        int numberOfPerson = 3;
        Row row = new Row(numberOfPerson);

        //when
        Position lineStartPosition = new Position(2);

        //then
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(lineStartPosition));
    }

    @Test
    void 사다리_라인_그리기_위치_미만_예외() {
        //given
        int numberOfPerson = 3;
        Row row = new Row(numberOfPerson);

        //when
        Position lineStartPosition = new Position(-1);

        //then
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(lineStartPosition));
    }

    @Test
    void 라인_그리기_좌측_라인_중복_예외() {
        //given
        int numberOfPerson = 3;
        Row row = new Row(numberOfPerson);
        Position position = new Position(0);
        row.drawLine(position);

        //when
        Position lineStartPosition = new Position(1);

        //then
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(lineStartPosition));

    }

    @Test
    void 라인_그리기_우측_라인_중복_예외() {
        //given
        int numberOfPerson = 3;
        Row row = new Row(numberOfPerson);
        Position position = new Position(1);
        row.drawLine(position);

        //when
        Position lineStartPosition = new Position(0);

        //then
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(lineStartPosition));

    }

    @Test
    void 해당_위치에_별을_찍을_수_있다(){
        // given
        Position row = Position.fromValue(0);
        Position col = Position.fromValue(0);
        LadderPosition currentPosition = LadderPosition.fromCoordinate(row,col);
        StringBuilder sb = new StringBuilder();
        Row row1 = new Row(3);

        // when
        row1.printRow(sb,Position.fromValue(0),currentPosition);
        String expectedOutput =
                "0* 0 0 \n";

        // then
        assertEquals(expectedOutput,sb.toString());
    }
    @Test
    void printRow_테스트(){
        // given
        Position row = Position.fromValue(0);
        Position col = Position.fromValue(0);
        LadderPosition currentPosition = LadderPosition.fromCoordinate(row,col);
        StringBuilder sb = new StringBuilder();
        Row row1 = new Row(3);

        // when
        row1.printRow(sb,Position.fromValue(0),currentPosition);
        String expectedOutput =
                "0* 0 0 \n";

        // then
        assertEquals(expectedOutput,sb.toString());
    }

}