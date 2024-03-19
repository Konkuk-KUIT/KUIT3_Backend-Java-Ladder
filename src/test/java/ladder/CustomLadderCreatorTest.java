package ladder;

import ladder.creator.CustomLadderCreator;
import ladder.model.LadderSize;
import ladder.model.Position;
import ladder.model.Row;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomLadderCreatorTest {
    @Test
    public void ladderSize_가_주어지면_정상적으로_사다리가_생성된다() {
        // Given
        LadderSize ladderSize = new LadderSize(3, 5); // 예시로 5*4 크기의 사다리 생성
        CustomLadderCreator ladderCreator = new CustomLadderCreator(ladderSize);

        // When
        Row[] rows = ladderCreator.getRows();

        // Then
        assertEquals(3, rows.length); // 행의 개수가 예상대로 생성되었는지 확인
        for (Row row : rows) {
            assertEquals(5, row.getSize()); // 각 행의 열의 개수가 예상대로 생성되었는지 확인
        }
    }

    @Test
    public void ladderSize_가_주어지고_사다리_라인_위치가_정해지면_정상적으로_draw한다() {
        // Given
        LadderSize ladderSize = new LadderSize(3, 3);
        CustomLadderCreator ladderCreator = new CustomLadderCreator(ladderSize);

        // When
        ladderCreator.drawLine(); // CustromLadder는 임의로 데이터를 처리함.

        // Then
        Row[] rows = ladderCreator.getRows();
        assertTrue(rows[0].hasLine(new Position(1))); // 해당 위치에 선이 그려졌는지 확인
        assertEquals(rows[0].getSize(),3);
        assertEquals(rows[1].getSize(),3);
        assertEquals(rows[2].getSize(),3);
    }
}
