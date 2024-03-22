package ladder.domain;

import ladder.core.Direction;
import ladder.core.Node;
import ladder.position.Position;
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
        Position currentPosition = Position.of(2);

        //when
        Position nextPosition = leftNode.move(currentPosition);

        //then
        assertEquals(1, nextPosition.getPosition());
    }

    @Test
    void 오른쪽_방향_위치_이동_확인() {
        //given
        Position currentPosition = Position.of(2);

        //when
        Position nextPosition = rightNode.move(currentPosition);

        //then
        assertEquals(3, nextPosition.getPosition());
    }

    @Test
    void 방향_없을_때_위치_이동_확인() {
        //given
        Position initialPosition = Position.of(2);

        //when
        Position nextPosition = noneNode.move(initialPosition);

        //then
        assertEquals(2, nextPosition.getPosition());
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

    @Test
    void 오른쪽_노드_심볼_추가() {
        StringBuilder sb = new StringBuilder();
        rightNode.appendSymbol(sb);
        assertEquals("1", sb.toString());
    }

    @Test
    void 왼쪽_노드_심볼_추가() {
        StringBuilder sb = new StringBuilder();
        leftNode.appendSymbol(sb);
        assertEquals("-1", sb.toString());
    }

    @Test
    void 노드_심볼_추가() {
        StringBuilder sb = new StringBuilder();
        noneNode.appendSymbol(sb);
        assertEquals("0", sb.toString());
    }
}