package ladder;

import java.util.Objects;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NodeTest {

    @Test
    void 디렉션이_같은_두_노드의_비교() {
        Assertions.assertEquals(Node.from(Direction.LEFT), Node.from(Direction.LEFT));
    }
}
