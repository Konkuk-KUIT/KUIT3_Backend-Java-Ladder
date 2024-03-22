package ladder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    void 사다리_생성_확인() {
        //given
        int numberOfRows = 3;
        int numberOfPerson = 5;

        //when
        LadderFrame ladderFrame = new LadderFrame(numberOfRows, numberOfPerson);

        //then
        assertNotNull(ladderFrame);
    }

    @Test
    void 사다리_시작위치_예외_처리() {
        //given
        int numberOfPerson = 3;
        int numberOfRows = 1;
        LadderFrame ladderFrame = new LadderFrame(numberOfRows, numberOfPerson);
        LadderGame ladderGame = new LadderGame(ladderFrame);

        //when
        Position position = Position.at(3);

        //then
        assertThrows(IllegalArgumentException.class, () -> ladderGame.playFrom(position));
    }

    @Test
    void 사다리_결과_확인() {
        //given
        int numberOfPerson = 4;
        int numberOfRows = 4;
        LadderFrame ladderFrame = new LadderFrame(numberOfRows, numberOfPerson);
        LadderGame ladderGame = new LadderGame(ladderFrame);
        ladderGame.drawLine(1,0);
        ladderGame.drawLine(1,2);
        ladderGame.drawLine(2,1);


        //when
        Position position = Position.at(0);
        Position resultPosition = ladderGame.playFrom(position);
        //then
        assertEquals(2, resultPosition.getColNum());

        //when
        position = Position.at(1);
        resultPosition = ladderGame.playFrom(position);
        //then
        assertEquals(0, resultPosition.getColNum());

        //when
        position = Position.at(2);
        resultPosition = ladderGame.playFrom(position);
        //then
        assertEquals(3, resultPosition.getColNum());

        //when
        position = Position.at(3);
        resultPosition = ladderGame.playFrom(position);
        //then
        assertEquals(1, resultPosition.getColNum());
    }
}