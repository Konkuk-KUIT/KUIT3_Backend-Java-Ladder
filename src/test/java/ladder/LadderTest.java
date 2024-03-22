package ladder;

import ladder.domain.NaturalNumber;
import ladder.domain.Position;
import ladder.game.LadderCreator;
import ladder.game.LadderRunner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {
    @Test
    void 사다리_생성_확인() {
        //given
        //int numberOfRows = 3;
        //int numberOfPerson = 5;

        NaturalNumber numberOfRows = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(5);

        //when
        LadderCreator ladderCreator = new LadderCreator(numberOfRows, numberOfPerson);
        //Ladder ladder  = new Ladder(NaturalNumber.of(numberOfRows), NaturalNumber.of(numberOfPerson));

        //then
        assertNotNull(ladderCreator);
    }

    @Test
    void 사다리_시작위치_예외_처리() {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        NaturalNumber numberOfRows = NaturalNumber.of(1);

        //Ladder ladder = new Ladder(NaturalNumber.of(numberOfRows), NaturalNumber.of(numberOfPerson));
        LadderCreator ladderCreator = new LadderCreator(numberOfRows, numberOfPerson);
        LadderRunner ladderRunner = new LadderRunner(ladderCreator);
        //when
        int position = 3;

        //then
        assertThrows(IllegalArgumentException.class, () -> ladderRunner.run(Position.of(position)));
    }

    @Test
    void 사다리_결과_확인() {
        //given
//        int numberOfPerson = 4;
//        int numberOfRows = 4;
        NaturalNumber numberOfPerson = NaturalNumber.of(4);
        NaturalNumber numberOfRows = NaturalNumber.of(4);

        LadderCreator ladderCreator = new LadderCreator(numberOfRows, numberOfPerson);
        LadderRunner ladderRunner = new LadderRunner(ladderCreator);
//        Ladder ladder = new Ladder(NaturalNumber.of(numberOfRows), NaturalNumber.of(numberOfPerson));
//        ladder.drawLine(Position.of(1),Position.of(0));
//        ladder.drawLine(Position.of(1),Position.of(2));
//        ladder.drawLine(Position.of(2),Position.of(1));

        Position pos1 = Position.of(1);
        Position pos2 = Position.of(0);
        Position pos3 = Position.of(2);
        ladderCreator.drawLine(pos1,pos2);
        ladderCreator.drawLine(pos1,pos3);
        ladderCreator.drawLine(pos3,pos1);

        //when
        Position position = Position.of(0);
        Position resultPosition = ladderRunner.run(position);
        //then
        assertEquals(2, resultPosition.get());

        //when
        position = Position.of(1);
        resultPosition = ladderRunner.run(position);
        //then
        assertEquals(0, resultPosition.get());

        //when
        position = Position.of(2);
        resultPosition = ladderRunner.run(position);
        //then
        assertEquals(3, resultPosition.get());

        //when
        position = Position.of(3);
        resultPosition = ladderRunner.run(position);
        //then
        assertEquals(1, resultPosition.get());

    }

    @Test
    void 별_찍기_테스트(){
        NaturalNumber numberOfPerson = NaturalNumber.of(4);
        NaturalNumber numberOfRows = NaturalNumber.of(4);

        LadderCreator ladderCreator = new LadderCreator(numberOfRows, numberOfPerson);
        LadderRunner ladderRunner = new LadderRunner(ladderCreator);


        Position pos1 = Position.of(1);
        Position pos2 = Position.of(0);
        Position pos3 = Position.of(2);
        ladderCreator.drawLine(pos1,pos2);
        ladderCreator.drawLine(pos1,pos3);
        ladderCreator.drawLine(pos3,pos1);

        Position position = Position.of(0);
        ladderRunner.showRunning(position);
    }
}