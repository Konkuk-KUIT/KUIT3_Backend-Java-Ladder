package ladder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CordinateTest {
    @Test
    void EqualTest() {
        Cordinate cor1 = Cordinate.of(1, 1);
        Cordinate cor2 = Cordinate.ofIntPosition(1, Position.initOf(1, NaturalNumber.from(3)));

        Assertions.assertEquals(cor1, cor2);
    }
}
