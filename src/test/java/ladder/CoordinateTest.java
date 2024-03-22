package ladder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CoordinateTest {
    @Test
    void EqualTest() {
        Coordinate cor1 = Coordinate.of(1, 1);
        Coordinate cor2 = Coordinate.ofIntPosition(1, Position.initOf(1, NaturalNumber.from(3)));

        Assertions.assertEquals(cor1, cor2);
    }
}
