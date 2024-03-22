package ladder;

import static constant.Direction.RIGHT;
import static exception.ErrorCode.DISALLOWED_CONTINUOUS_LINE;
import static exception.ErrorCode.INVALID_NUMBER_OF_LADDER;
import static exception.ErrorCode.INVALID_NUMBER_OF_POSITION;
import static exception.ErrorCode.LINE_ALREADY_EXISTS;
import static exception.ErrorCode.OUT_OF_BOUNDS_COL_POSITION;
import static exception.ErrorCode.OUT_OF_BOUNDS_RAW_POSITION;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import constant.Direction;
import exception.LadderException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.LadderNumber;
import utils.LadderSize;
import utils.Position;

class LadderCreatorTest {

  private LadderCreator creator;

  @BeforeEach
  void init() {
    LadderNumber numberOfRows = LadderNumber.of(3);
    LadderNumber numberOfPerson = LadderNumber.of(3);

    LadderSize size = LadderSize.of(numberOfRows, numberOfPerson);

    creator = LadderCreator.of(size);
  }

  @Test
  void LadderCreator_생성_확인() {
    //then
    assertNotNull(creator);
  }

  @Test
  void LadderNumber_생성_성공() {
    assertEquals(1, LadderNumber.of(1).getIntValue());
  }

  @Test
  void LadderNumber_생성_실패__양수가_아님() {
    LadderException e = assertThrows(LadderException.class, () -> {
      LadderNumber.of(0);
    });
    assertEquals(INVALID_NUMBER_OF_LADDER, e.getErrorCode());
  }

  @Test
  void LadderNumber_생성_실패__범위_초과() {
    LadderException e = assertThrows(LadderException.class, () -> {
      LadderNumber.of(1_000_001);
    });
    assertEquals(INVALID_NUMBER_OF_LADDER, e.getErrorCode());
  }

  @Test
  void Position_생성_실패__범위_미만() {
    //when
    LadderException e = assertThrows(LadderException.class, () -> {
      Position.of(0);
    });

    //then
    assertEquals(INVALID_NUMBER_OF_POSITION, e.getErrorCode());
  }

  @Test
  void 사다리_그리기_성공() {
    //when
    creator.drawLine(Position.of(1), Position.of(1));

    //then
    Direction curDirection = creator.getRows()[1].getNodes()[1].getDirection();
    assertEquals(curDirection, RIGHT);
  }

  @Test
  void 사다리_그리기_실패__row_초과() {
    //when
    LadderException e = assertThrows(LadderException.class, () -> {
      creator.drawLine(Position.of(4), Position.of(1));
    });

    //then
    assertEquals(OUT_OF_BOUNDS_RAW_POSITION, e.getErrorCode());
  }

  @Test
  void 사다리_그리기_실패__col_넘어감() {
    //when
    LadderException e = assertThrows(LadderException.class, () -> {
      creator.drawLine(Position.of(1), Position.of(4));
    });

    //then
    assertEquals(OUT_OF_BOUNDS_COL_POSITION, e.getErrorCode());
  }

  @Test
  void 사다리_그리기_실패__왼쪽에_이미_있음() {
    //given
    creator.drawLine(Position.of(1), Position.of(1));

    //when
    LadderException e = assertThrows(LadderException.class, () -> {
      creator.drawLine(Position.of(1), Position.of(2));
    });

    //then
    assertEquals(DISALLOWED_CONTINUOUS_LINE, e.getErrorCode());
  }

  @Test
  void 사다리_그리기_실패__오른쪽에_이미_있음() {
    //given
    creator.drawLine(Position.of(1), Position.of(2));

    //when
    LadderException e = assertThrows(LadderException.class, () -> {
      creator.drawLine(Position.of(1), Position.of(1));
    });

    //then
    assertEquals(DISALLOWED_CONTINUOUS_LINE, e.getErrorCode());
  }

  @Test
  void 사다리_그리기_실패__이미_있음() {
    //given
    creator.drawLine(Position.of(1), Position.of(1));

    //when
    LadderException e = assertThrows(LadderException.class, () -> {
      creator.drawLine(Position.of(1), Position.of(1));
    });

    //then
    assertEquals(LINE_ALREADY_EXISTS, e.getErrorCode());
  }
}