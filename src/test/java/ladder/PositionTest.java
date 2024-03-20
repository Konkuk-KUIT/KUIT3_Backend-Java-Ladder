package ladder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PositionTest {
    @Test
    void position_Next() {
        Position position = Position.initOf(0, NaturalNumber.from(5));
        Assertions.assertEquals(1, position.next().get());
    }
}
