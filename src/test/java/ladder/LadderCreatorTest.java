package ladder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class LadderCreatorTest {

    @Test
    void 객체_생성_확인(){
        //given
        int rownum = 4;
        int colnum = 5;
        NaturalNum five = NaturalNum.of(5);
        NaturalNum four = NaturalNum.of(4);
        //when
        LadderCreator ladderCreator = LadderCreator.of(five,four);

        //then
        assertNotNull(ladderCreator);
    }

    @Test
    void row_반환_확인(){

        //given
        int rownum = 4;
        int colnum = 5;
        Row[] rows;
        NaturalNum five = NaturalNum.of(5);
        NaturalNum four = NaturalNum.of(4);
        //when
        LadderCreator ladderCreator = LadderCreator.of(five,four);
        rows = ladderCreator.getrows();

        //then
        assertNotNull(rows);
    }


    //열 생성 개수 테스트
    //높이, 개수

    //예외 처리 테스트



    /*@Test
    void 선그리기_테스트(){
        //given
        int rownum = 4;
        int colnum = 5;
        Row[] rows;

        //when
        LadderCreator ladderCreator = LadderCreator.of(rownum,colnum);
        ladderCreator.DrawLine(3,2);
        rows = ladderCreator.getrows();

        //then
        assertNotEquals(0, rows[3]);


    }*/

}
