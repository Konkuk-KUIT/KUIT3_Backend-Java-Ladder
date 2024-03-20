package ladder;

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

    @Test
    void 사다리_시작위치_예외_처리() {
        //given
        NaturalNumber numberOfRows = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(4);
        Ladder ladder = new Ladder(numberOfRows, numberOfPerson);

        //when
        int position = 5;

        //then
        assertThrows(IllegalArgumentException.class, () -> ladder.run(position));
    }

    @Test
    void 사다리_결과_확인() {
        //given
        NaturalNumber numberOfRows = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(4);
        Ladder ladder = new Ladder(numberOfRows, numberOfPerson);
        ladder.drawLine(0, 0);
        ladder.drawLine(1, 1);
        ladder.drawLine(2, 0);
        ladder.drawLine(2, 2);

        //when
        int position = 0;
        int resultPosition = ladder.run(position);
        //then
        assertEquals(3, resultPosition);

        //when
        position = 1;
        resultPosition = ladder.run(position);
        //then
        assertEquals(1, resultPosition);

        //when
        position = 2;
        resultPosition = ladder.run(position);
        //then
        assertEquals(0, resultPosition);

        //when
        position = 3;
        resultPosition = ladder.run(position);
        //then
        assertEquals(2, resultPosition);
    }

    @Test
    void 사다리_출력하기() {
        //given
        NaturalNumber numberOfRows = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(4);
        Ladder ladder = new Ladder(numberOfRows, numberOfPerson);
        ladder.drawLine(0, 0);
        ladder.drawLine(1, 1);
        ladder.drawLine(2, 0);
        ladder.drawLine(2, 2);

        //when
        String ladderResult = ladder.printLadder();

        //then
        String expectedResult = "1 -1 0 0 \n0 1 -1 0 \n1 -1 1 -1 \n";
        assertEquals(expectedResult, ladderResult);
    }

    @Test
    void 임의_사다리_정상_생성_팩토리_없이() {
        //given
        RandomLadderCreator randomLadderCreator = new RandomLadderCreator();
        Ladder ladder = randomLadderCreator.createLadder(NaturalNumber.of(3), NaturalNumber.of(4));

        //when
        String ladderResult = ladder.printLadder();

        //then
        assertEquals(6, ladderResult.chars()
                .filter(c -> c == '0')
                .count());
    }

    @Test
    void 임의_사다리_정상_생성_팩토리로() {
        //given
        LadderGame ladderGame = LadderGameFactory.createRandomLadderGame(NaturalNumber.of(3), NaturalNumber.of(4));

        //when
        String ladderResult = ladderGame.printLadder();

        //then
        assertEquals(6, ladderResult.chars()
                .filter(c -> c == '0')
                .count());
    }

    @Test
    void 사다리_게임_결과_정상_출력() {
        //given
        NaturalNumber numberOfRows = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(4);
        LadderGame ladderGame = LadderGameFactory.createRandomLadderGame(numberOfRows, numberOfPerson);

        //when
        String gameResult = ladderGame.printGameResult();

        //then
        assertEquals(2, gameResult.chars()
                .filter(c -> c == '0')
                .count());
        assertEquals(2, gameResult.chars()
                .filter(c -> c == '1')
                .count());
        assertEquals(2, gameResult.chars()
                .filter(c -> c == '2')
                .count());
        assertEquals(2, gameResult.chars()
                .filter(c -> c == '3')
                .count());
    }
}
