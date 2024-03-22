package ladder.game;

import ladder.domain.NaturalNumber;
import ladder.domain.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderGameTest {
    @Test
    void 게임_생성_테스트(){
        // given
        NaturalNumber numberOfPerson = NaturalNumber.of(4);
        NaturalNumber numberOfRows = NaturalNumber.of(4);

        LadderCreator ladderCreator = new LadderCreator(numberOfRows, numberOfPerson);
        LadderGame ladderGame = new LadderGame(ladderCreator);

        Position pos1 = Position.of(1);
        Position pos2 = Position.of(0);
        Position pos3 = Position.of(2);
        ladderCreator.drawLine(pos1,pos2);
        ladderCreator.drawLine(pos1,pos3);
        ladderCreator.drawLine(pos3,pos1);

        //when
        Position position = Position.of(0);
        Position resultPosition = ladderGame.playGame(position);

        //then
        assertEquals(2, resultPosition.get());
    }

    @Test
    void 사다리_출력_테스트(){
        // given
        NaturalNumber numberOfPerson = NaturalNumber.of(4);
        NaturalNumber numberOfRows = NaturalNumber.of(4);

        LadderCreator ladderCreator = new LadderCreator(numberOfRows, numberOfPerson);
        LadderGame ladderGame = new LadderGame(ladderCreator);

        Position pos1 = Position.of(1);
        Position pos2 = Position.of(0);
        Position pos3 = Position.of(2);
        ladderCreator.drawLine(pos1,pos2);
        ladderCreator.drawLine(pos1,pos3);
        ladderCreator.drawLine(pos3,pos1);

        //when

        //then
    }
}