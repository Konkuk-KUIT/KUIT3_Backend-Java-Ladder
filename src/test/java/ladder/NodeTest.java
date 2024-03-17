package ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    private Node leftNode;
    private Node rightNode;
    private Node noneNode;

    @BeforeEach
    void setUp() {
        leftNode = Node.of(Direction.LEFT);
        rightNode = Node.of(Direction.RIGHT);
        noneNode = Node.of(Direction.NONE);
    }

    @Test
    void 왼쪽_방향_위치_이동_확인() {
        //given
        Position position = Position.of(2);

        //when
        Position nextPosition = leftNode.move(position);

        //then
        assertEquals(1, nextPosition.getValue());
    }

    @Test
    void 오른쪽_방향_위치_이동_확인() {
        //given
        Position position = Position.of(1);

        //when
        Position nextPosition = rightNode.move(position);

        //then
        assertEquals(2, nextPosition.getValue());
    }

    @Test
    void 무방향_노드_위치_이동_확인() {
        //given
        Position position = Position.of(2);

        //when
        Position nextPosition = noneNode.move(position);

        //then
        assertEquals(2, nextPosition.getValue());
    }

    @Test
    void 오른쪽_방향_확인() {
        assertTrue(rightNode.isRight());
        assertFalse(leftNode.isRight());
        assertFalse(noneNode.isRight());
    }

    @Test
    void 왼쪽_방향_확인() {
        assertTrue(leftNode.isLeft());
        assertFalse(rightNode.isLeft());
        assertFalse(noneNode.isLeft());
    }

}