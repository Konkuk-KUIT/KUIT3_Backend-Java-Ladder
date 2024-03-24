package ladder;

import ladder.wrapper.Direction;
import ladder.wrapper.Node;
import ladder.wrapper.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class NodeTest {

    @ParameterizedTest
    @EnumSource(value = Direction.class, names = {"LEFT", "RIGHT"})
    @DisplayName("같은 Direction일 경우 두 객체는 같다 처리")
    void sameDirectionSameObject(Direction direction) {
        // given

        // when
        Node node1 = Node.from(direction);
        Node node2 = Node.from(direction);

        // then
        Assertions.assertEquals(node1, node2);
    }

    @Test
    @DisplayName("오른쪽 노드일 경우 position + 1")
    void rightNodeMoveRight() {
        // given
        Node node = Node.from(Direction.RIGHT);
        Position position = Position.from(3);

        // when
        Position movedPosition = node.move(position);

        // then
        Assertions.assertEquals(movedPosition.get(), 4);
    }

    @Test
    @DisplayName("왼쪽 노드일 경우 position - 1")
    void leftNodeMoveLeft() {
        // given
        Node node = Node.from(Direction.LEFT);
        Position position = Position.from(3);

        // when
        Position movedPosition = node.move(position);

        // then
        Assertions.assertEquals(movedPosition.get(), 2);
    }
}
