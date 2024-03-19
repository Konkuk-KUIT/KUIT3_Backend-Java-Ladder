package ladder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class LadderRunnerTest {

    @Test
    void 객체_생성_확인(){
        //given
        int rownum = 4;
        int colnum = 5;
        LadderCreator ladderCreator = LadderCreator.of(rownum,colnum);
        //when
        LadderRunner ladderRunner = LadderRunner.of(ladderCreator.getrows());
        //then
        assertNotNull(ladderRunner);
    }

}
