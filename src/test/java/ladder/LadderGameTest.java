package ladder;

import ladder.game.LadderGame;
import ladder.game.LadderGameFactory;
import ladder.wrapper.NaturalNumber;
import ladder.wrapper.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderGameTest {
    @Test
    void 임의_사다리_정상_생성_팩토리로() {
        //given
        NaturalNumber numberOfRows = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(4);
        LadderGame ladderGame = LadderGameFactory.createRandomLadderGame(numberOfRows, numberOfPerson);

        //when
        String ladderResult = ladderGame.printLadder();

        //then
        assertEquals(6, ladderResult.chars()
                .filter(c -> c == '0')
                .count());
    }

    @Test
    void 사다리_결과_확인() {
        //given
        NaturalNumber numberOfRows = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(4);
//        Ladder ladder = new Ladder(numberOfRows, numberOfPerson);
//        ladder.drawLine(Position.of(0, numberOfRows), Position.of(0, numberOfPerson));
//        ladder.drawLine(Position.of(1, numberOfRows), Position.of(1, numberOfPerson));
//        ladder.drawLine(Position.of(2, numberOfRows), Position.of(0, numberOfPerson));
//        ladder.drawLine(Position.of(2, numberOfRows), Position.of(2, numberOfPerson));
        LadderGame ladderGame = LadderGameFactory.createFixedLadderGame(numberOfRows, numberOfPerson);

        //when
        Position position = Position.of(0, numberOfPerson);
        Position resultPosition = ladderGame.run(position);
        //then
        assertEquals(3, resultPosition.get());

        //when
        position = position.next();
        resultPosition = ladderGame.run(position);
        //then
        assertEquals(1, resultPosition.get());

        //when
        position = position.next();
        resultPosition = ladderGame.run(position);
        //then
        assertEquals(0, resultPosition.get());

        //when
        position = position.next();
        resultPosition = ladderGame.run(position);
        //then
        assertEquals(2, resultPosition.get());
    }
}
