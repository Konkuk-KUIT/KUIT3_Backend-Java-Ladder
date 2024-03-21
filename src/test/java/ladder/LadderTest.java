package ladder;

import ladder.creator.RandomLadderCreator;
import ladder.wrapper.NaturalNumber;
import ladder.wrapper.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LadderTest {

    @Test
    void 사다리_생성_확인() {
        //given
        NaturalNumber numberOfRows = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(4);

        //when
        Ladder ladder = new Ladder(numberOfRows, numberOfPerson);

        //then
        assertNotNull(ladder);
    }

    // 테스트를 위해 준비할 과정이 없으면 given 생략해도 되는지?
    @Test
    void 사다리_시작위치_예외_처리() {
        //when
        // 가능한 사다리 시작위치는 0 ~ 3
        NaturalNumber numberOfPerson = NaturalNumber.of(4);

        //then
        assertThrows(IllegalArgumentException.class, () -> Position.of(5, numberOfPerson));
    }

    @Test
    void 임의_사다리_정상_생성_팩토리_없이() {
        //given
        NaturalNumber numberOfRows = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(4);
        RandomLadderCreator randomLadderCreator = new RandomLadderCreator();
        Ladder ladder = randomLadderCreator.createLadder(numberOfRows, numberOfPerson);

        //when
        String ladderResult = ladder.printLadder();

        //then
        assertEquals(6, ladderResult.chars()
                .filter(c -> c == '0')
                .count());
    }
}
