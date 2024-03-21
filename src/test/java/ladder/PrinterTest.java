package ladder;

import ladder.game.LadderGame;
import ladder.game.LadderGameFactory;
import ladder.wrapper.NaturalNumber;
import ladder.wrapper.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrinterTest {
    @DisplayName("RowPrinter 테스트")
    @Test
    void 사다리_한_행_출력() {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.of(4);
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.of(1, numberOfPerson));

        //when
        String rowResult = row.printRow();

        //then
        assertEquals("0 1 -1 0 \n", rowResult);
    }

    @DisplayName("LadderPrinter 테스트")
    @Test
    void 사다리_전체_출력() {
        //given
        NaturalNumber numberOfRows = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(4);
        Ladder ladder = new Ladder(numberOfRows, numberOfPerson);
        ladder.drawLine(Position.of(0, numberOfRows), Position.of(0, numberOfPerson));
        ladder.drawLine(Position.of(1, numberOfRows), Position.of(1, numberOfPerson));
        ladder.drawLine(Position.of(2, numberOfRows), Position.of(0, numberOfPerson));
        ladder.drawLine(Position.of(2, numberOfRows), Position.of(2, numberOfPerson));

        //when
        String ladderResult = ladder.printLadder();

        //then
        String expectedResult = "1 -1 0 0 \n0 1 -1 0 \n1 -1 1 -1 \n";
        assertEquals(expectedResult, ladderResult);
    }

    @DisplayName("LadderGameResultPrinter 테스트")
    @Test
    void 사다리_게임_결과_모두_정상_출력() {
        //given
        NaturalNumber numberOfRows = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(4);
        LadderGame ladderGame = LadderGameFactory.createRandomLadderGame(numberOfRows, numberOfPerson);

        //when
        ladderGame.runAllPlayer();

        //then
        String gameResult = ladderGame.printGameResult();
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
