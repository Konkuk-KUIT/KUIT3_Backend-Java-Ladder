package ladder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import ladder.wrapper.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositionTest {
    @Test
    @DisplayName("prev를 호출했을때 작이진 포지션을 반환하는지 테스트")
    void prevedPosition() {
        // given
        Position position = Position.from(1);
        Position expected = Position.from(0);

        // when
        Position prevPosition = position.prev();

        // then
        assertEquals(expected, prevPosition);
    }
}
