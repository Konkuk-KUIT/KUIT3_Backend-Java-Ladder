package ladder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NodeTest {

    @Test
    void 디렉션이_같은_두_노드의_비교() {
        Assertions.assertEquals(Node.from(Direction.LEFT), Node.from(Direction.LEFT));
    }

    @Test
    void move_left_test() {
        Node node = Node.from(Direction.LEFT);
        Position position = Position.initFrom(3, NaturalNumber.from(5));
        Position movedPosition = node.move(position);
        Assertions.assertEquals(movedPosition.get(), 2);
    }
}
