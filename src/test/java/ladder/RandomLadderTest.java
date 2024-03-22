package ladder;

import LadderCreator.*;
import model.LadderSize;
import model.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RandomLadderTest {
    @Test
    void 랜덤사다리_생성_확인() {
        //given
        //when
        LadderCreator ladder  = new RandomLadderCreator(LadderSize.InttoLadderSize(3,5));

        //then
        assertNotNull(ladder);
    }
    @Test
    void 랜덤사다리_생성_위치_확인() {
        //given
        //when
        LadderCreator ladder  = new RandomLadderCreator(LadderSize.InttoLadderSize(3,5));

        LadderGame ladderGame = new LadderGame(ladder);

        //when
        Position resultPosition = ladderGame.run_game(Position.of(0));
    }
}
