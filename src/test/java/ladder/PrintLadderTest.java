package ladder;

import org.junit.jupiter.api.Test;

public class PrintLadderTest {
    //Step02 Testcode
    @Test
    void 사다리_출력() {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.of(4);
        NaturalNumber numberOfRow = NaturalNumber.of(4);

        LadderCreator ladderCreator = new LadderCreator(numberOfRow, numberOfPerson);
        LadderGame ladderGame = new LadderGame(ladderCreator);

        ladderCreator.drawLine(Position.of(1), Position.of(0));
        ladderCreator.drawLine(Position.of(1), Position.of(2));
        ladderCreator.drawLine(Position.of(2), Position.of(1));

        //when (사다리의 출력을 위해 사다리의 사람의 position값을 아무숫자나 넣어서 만들어진 사다리 출력함)
        int position = 0;
        ladderGame.run(Position.of(position));

//        then
//        0  0  0  0
//        1 -1  1 -1
//        0  1 -1  0
//        0  0  0  0
    }

    @Test
    void 사용자_위치_사다리_출력(){
        //given
        NaturalNumber numberOfPerson = NaturalNumber.of(4);
        NaturalNumber numberOfRow = NaturalNumber.of(4);

        LadderCreator ladderCreator = new LadderCreator(numberOfRow, numberOfPerson);
        LadderGame ladderGame = new LadderGame(ladderCreator);

        ladderCreator.drawLine(Position.of(1), Position.of(0));
        ladderCreator.drawLine(Position.of(1), Position.of(2));
        ladderCreator.drawLine(Position.of(2), Position.of(1));

        //when (사다리의 출력을 위해 사다리의 사람의 position값을 아무숫자나 넣어서 만들어진 사다리 출력함)
        int position = 1;
        ladderGame.run(Position.of(position));

    }
}
