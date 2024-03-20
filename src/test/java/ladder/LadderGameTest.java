package ladder;

import ladder.creator.CustomLadderCreator;
import ladder.creator.LadderCreator;

import ladder.model.LadderSize;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LadderGameTest {


    @Test
    void 사다리_생성_확인() {
        //given
        LadderSize ladderSize = new LadderSize(3,5);

        //when
        LadderCreator ladderCreator = new CustomLadderCreator(ladderSize);

        //then
        assertNotNull(ladderCreator);
    }

    @Test
    public void 게임이_실행되면_선이_제대로_그어진다() {
        // Given

        // When
        //ladderGame.play();

        // Then

    }
}
