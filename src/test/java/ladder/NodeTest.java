package ladder;

import jdk.jshell.execution.DirectExecutionControl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NodeTest {

    @Test
    void 객체_생성_확인(){
        //given
        Direction direction = Direction.LEFT;
        //when
        Node node = Node.SetNode(direction);
        //then
        assertNotNull(node);
    }

    @Test
    void next_함수_테스트(){
        //given
        Direction direction = Direction.LEFT;
        //when
        Node node = Node.SetNode(direction);
        //then
        assertTrue(Direction.LEFT.equals(node.NextPosition()));


    }

}
