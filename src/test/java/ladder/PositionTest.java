package ladder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositionTest {
    @Test
    @DisplayName("사람 수보다 큰 값이 포지션으로 설정되려 할 때 Exception을 던지는 테스트.")
    void positionLargerThanNumberOfPerson() {
        // given
        NaturalNumber numberOfPerson = NaturalNumber.from(5);

        // then
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            Position.initOf(6, numberOfPerson);
        });

        assertEquals(ExceptionMessage.INVALID_POSITION.getErrorMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("next를 호출했을때 증가된 포지션을 반환하는지 테스트")
    void nextedPosition() {
        // given
        Position position = Position.initOf(0, NaturalNumber.from(5));
        Position expected = Position.initOf(1, NaturalNumber.from(5));

        // when
        Position nextPosition = position.next();

        // then
        assertEquals(expected, nextPosition);
    }

    @Test
    @DisplayName("prev를 호출했을때 작이진 포지션을 반환하는지 테스트")
    void prevedPosition() {
        // given
        Position position = Position.initOf(1, NaturalNumber.from(5));
        Position expected = Position.initOf(0, NaturalNumber.from(5));

        // when
        Position prevPosition = position.prev();

        // then
        assertEquals(expected, prevPosition);
    }
}
