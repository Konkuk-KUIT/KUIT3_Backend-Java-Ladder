package ladder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import utils.LadderNumber;
import utils.Position;
import utils.Row;

class RowTest {

  @Test
  void 참여자_한_명_제자리_이동() {
    //given
    LadderNumber numberOfPerson = LadderNumber.of(1);
    Row row = Row.of(numberOfPerson);

    //when
    Position position = Position.of(1);

    //then
    assertEquals(1, row.getNextPosition(position).getIntValue());
  }

  @Test
  void 참여자_두_명_사다리_열간_이동() {
    //given
    Position cur = Position.of(1);
    LadderNumber numberOfPerson = LadderNumber.of(2);
    Row row = Row.of(numberOfPerson);
    row.drawLine(cur);

    //when
    cur = row.getNextPosition(cur);  // 1 -> 2
    //then
    assertEquals(2, cur.getIntValue());

    //when
    cur = row.getNextPosition(cur); // 2 -> 1
    //then
    assertEquals(1, cur.getIntValue());
  }

  @Test
  void 참여자_세_명_사다리_열간_이동() {
    //given
    Position cur = Position.of(1);
    LadderNumber numberOfPerson = LadderNumber.of(3);
    Row row = Row.of(numberOfPerson);
    row.drawLine(cur);

    //when
    cur = row.getNextPosition(cur); // 1 -> 2
    //then
    assertEquals(2, cur.getIntValue());

    //when
    cur = row.getNextPosition(cur); // 2 -> 1
    //then
    assertEquals(1, cur.getIntValue());

    //when
    cur = Position.of(3);
    cur = row.getNextPosition(cur); // 3 -> 3
    //then
    assertEquals(3, cur.getIntValue());
  }
}