package ladder;

import static exception.ErrorCode.OUT_OF_BOUNDS_START_POSITION;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import exception.LadderException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.LadderNumber;
import utils.LadderSize;
import utils.Position;

class LadderGameTest {

  private LadderCreator creator;
  private LadderGame game;

  @BeforeEach
  void init() {
    LadderNumber numberOfRows = LadderNumber.of(4);
    LadderNumber numberOfPerson = LadderNumber.of(4);

    LadderSize size = LadderSize.of(numberOfRows, numberOfPerson);

    creator = LadderCreator.of(size);
    game = LadderGame.of(creator);

    creator.drawLine(Position.of(2), Position.of(1));
    creator.drawLine(Position.of(2), Position.of(3));
    creator.drawLine(Position.of(3), Position.of(2));
  }

  @Test
  void 게임_생성_확인() {
    assertNotNull(game);
  }

  @Test
  void 게임_결과_확인() {
    //when
    Position start = Position.of(1);
    int resultPosition = game.run(start);
    //then
    assertEquals(3, resultPosition);

    //when
    start = Position.of(2);
    resultPosition = game.run(start);
    //then
    assertEquals(1, resultPosition);

    //when
    start = Position.of(3);
    resultPosition = game.run(start);
    //then
    assertEquals(4, resultPosition);

    //when
    start = Position.of(4);
    resultPosition = game.run(start);
    //then
    assertEquals(2, resultPosition);
  }

  @Test
  void 게임_시작_실패__col_넘어감() {
    //when
    Exception e = assertThrows(LadderException.class, () -> {
      game.run(Position.of(5));
    });

    //then
    assertEquals(OUT_OF_BOUNDS_START_POSITION.getMessage(), e.getMessage());
  }
}