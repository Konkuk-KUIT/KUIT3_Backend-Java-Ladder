package ladder;

import ladder.creator.CustomLadderCreator;
import ladder.creator.RandomLadderCreator;
import ladder.model.LadderSize;
import ladder.model.Position;
import ladder.model.Row;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomLadderCreatorTest {
    @Test
    public void ladderSize_가_주어지면_정상적으로_사다리가_생성된다() {
        // Given
        LadderSize ladderSize = new LadderSize(3, 5); // 예시로 5*4 크기의 사다리 생성
        RandomLadderCreator ladderCreator = new RandomLadderCreator(ladderSize);

        // When
        Row[] rows = ladderCreator.getRows();

        // Then
        assertEquals(3, rows.length); // 행의 개수가 예상대로 생성되었는지 확인
        for (Row row : rows) {
            assertEquals(5, row.getSize()); // 각 행의 열의 개수가 예상대로 생성되었는지 확인
        }
    }


    @Test
    public void ladderSize_가_주어지면_정상적으로_라인_수를_반환한다(){
        // Given
        LadderSize ladderSize = new LadderSize(3, 3); // 예시로 5*4 크기의 사다리 생성
        RandomLadderCreator ladderCreator = new RandomLadderCreator(ladderSize);

        // When
        int cnt =  Math.round(ladderCreator.getLineCnt());

        // Then
        assertEquals(cnt,3);
    }

    @Test
    public void drawLine_을_호출하면_자동으로_라인을_그려준다(){
        // Given
        LadderSize ladderSize = new LadderSize(4, 4);
        RandomLadderCreator ladderCreator = new RandomLadderCreator(ladderSize);
        int expectedTotalLines = ladderCreator.getLineCnt();

        // When
        ladderCreator.drawLine();

        // Then
        Row[] rows = ladderCreator.getRows();
        int totalLines = 0;
        for (Row row : rows) {
            for (int i = 0; i < row.getSize()-1; i++) {
                if (row.isRight(Position.fromValue(i))) {
                    totalLines++;
                }
            }
        }
        assertEquals(expectedTotalLines, totalLines); // 총 라인 개수와 일치하는지 확인
    }
}
