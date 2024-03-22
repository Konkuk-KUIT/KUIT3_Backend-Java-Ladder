package ladder;

import Numbers.NaturalNum;
import Numbers.Position;
import org.junit.jupiter.api.Test;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DrawRandomLineTest {

    @Test
    void 사다리_출력_결과_확인(){
        //given
        int numberOfPerson = 4;
        int numberOfRows = 4;
        Ladder ladder = new Ladder(numberOfRows, numberOfPerson);
        ladder.drawRandomLine();

        //when
        //int position = 0;
        //int resultPosition = ladder.run(position);

        Vector<Integer> checkValue =new Vector<Integer>();
        //when
        for(int i =0;i<4;i++){
            int position = i;
            int resultPosition = ladder.runAndPrint(position);
            checkValue.add(resultPosition);
        }



        //then
        assertTrue(checkValue.contains(0));
        assertTrue(checkValue.contains(1));
        assertTrue(checkValue.contains(2));
        assertTrue(checkValue.contains(3));
        //assertEquals(1, resultPosition));

    }

    @Test
    void 사다리_출력_랜덤생성_확인(){
        //given
        int numberOfPerson = 4;
        int numberOfRows = 4;
        Ladder ladder = new Ladder(numberOfRows, numberOfPerson);
        ladder.drawRandomLine();

        //when
        //int position = 0;
        //int resultPosition = ladder.run(position);


        //when
        for(int i =0;i<4;i++){
            int position = i;
            int resultRandom = ladder.runAndPrint(position);
            int resultDefault = ladder.run(position);
            //then
            assertEquals(resultDefault,resultRandom);
        }

    }

}
