package game;

import game.field.Field;
import game.field.Ladder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class LadderGameTest {

    @Test
    void 사다리게임_생성_확인(){
        //given
        int numberOfRows = 3;
        int numberOfPerson = 5;

        //when
        Field field = new Ladder(numberOfRows, numberOfPerson);
        Game game = new LadderGame(field);

        //then
        assertNotNull(game);
    }

    @Test
    void 사다리게임_플레이_확인(){
        //given
        int numberOfRows = 3;
        int numberOfPerson = 5;

        //when
        Field field = new Ladder(numberOfRows, numberOfPerson);
        Game game = new LadderGame(field);

        //then
        game.play(numberOfRows,numberOfPerson);
        //TODO
    }

    @Test
    void 사다리_자동_생성(){
        //given
        int numberOfPerson = 4;
        int numberOfRows = 4;
        LadderGame ladderGame=GameFactory.createLadderGameByRandom(numberOfRows,numberOfPerson);
        //when
        int row = 0;
        int col = 0;


        //then
        ladderGame.playWithPrint(row,col);

    }
}
