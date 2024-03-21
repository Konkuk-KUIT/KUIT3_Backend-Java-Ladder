package ladder;

import ladder.application.LadderCreator;
import ladder.application.LadderGame;
import ladder.application.LadderGameFactory;
import ladder.model.NaturalNumber;
import ladder.model.Position;
import org.junit.jupiter.api.Test;

import static ladder.application.LadderGameFactory.CreatorType.AUTO;
import static org.junit.jupiter.api.Assertions.*;

class LadderGameTest {

    @Test
    void LadderCreator_생성_확인() {
        //given
        NaturalNumber numberOfRows = NaturalNumber.of(5);
        NaturalNumber numberOfPersons = NaturalNumber.of(5);

        //when
        LadderCreator ladderCreator = new LadderCreator(numberOfRows, numberOfPersons);

        //then
        assertNotNull(ladderCreator);
    }

    @Test
    void LadderGame_생성_확인(){
        //given
        NaturalNumber numberOfRows = NaturalNumber.of(5);
        NaturalNumber numberOfPersons = NaturalNumber.of(5);
        LadderCreator ladderCreator = new LadderCreator(numberOfRows, numberOfPersons);
        //when
        LadderGame ladderGame = new LadderGame(ladderCreator);

        //then
        assertNotNull(ladderGame);
    }
    @Test
    void 사다리_시작위치_예외_처리() {
        //given
        NaturalNumber numberOfRows = NaturalNumber.of(3);
        NaturalNumber numberOfPersons = NaturalNumber.of(1);
        LadderCreator ladderCreator = new LadderCreator(numberOfRows, numberOfPersons);
        LadderGame ladderGame = new LadderGame(ladderCreator);

        //when
        Position startPosition = Position.of(3);

        //then
        assertThrows(IllegalArgumentException.class, () -> ladderGame.runGame(startPosition));
    }

    @Test
    void 사다리_결과_확인() {
        //given
        NaturalNumber numberOfRows = NaturalNumber.of(4);
        NaturalNumber numberOfPersons = NaturalNumber.of(4);
        LadderCreator ladderCreator = new LadderCreator(numberOfRows, numberOfPersons);
        ladderCreator.drawLine(1,0);
        ladderCreator.drawLine(1,2);
        ladderCreator.drawLine(2,1);

        LadderGame ladderGame = new LadderGame(ladderCreator);

        //when
        Position startPosition = Position.of(0);
        Position resultPosition = ladderGame.runGame(startPosition);
        //then
        assertEquals(2, resultPosition.getPosition());


        //when
        startPosition = Position.of(1);
        resultPosition = ladderGame.runGame(startPosition);
        //then
        assertEquals(0, resultPosition.getPosition());

        //when
        startPosition = Position.of(2);
        resultPosition = ladderGame.runGame(startPosition);
        //then
        assertEquals(3, resultPosition.getPosition());


        //when
        startPosition = Position.of(3);
        resultPosition = ladderGame.runGame(startPosition);
        //then
        assertEquals(1, resultPosition.getPosition());

    }
    @Test
    void 자동_사다리_생성_확인(){
        //given
        int numberOfRow = 5;
        int numberOfPerson = 5;

        //when
        LadderGame ladderGame = LadderGameFactory.createLadderGame(numberOfRow,numberOfPerson,AUTO);

        //then
        assertNotNull(ladderGame);
    }


}