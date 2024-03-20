package ladder;

import ladder.game.LadderRunner;
import ladder.model.LadderPosition;
import ladder.model.Position;
import ladder.model.Row;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderRunnerTest {

    @Test
    public void row_값이_주어지면_run_수행시_목적지로_이동한다() {
        // Given
        // row가 주어졌을 때 3*3
        Row[] rows = new Row[3];
        for(int i = 0; i < 3; i++) {
            rows[i] = new Row(3);
        }
        LadderRunner ladderRunner = new LadderRunner(rows);

        // When
        Position startPosition = new Position(0); // 시작 위치 설정
        int destination = ladderRunner.run(startPosition);

        // Then
        // 원하는 목적지가 제대로 반환되는지 확인
        assertEquals(0, destination);
    }

    @Test
    public void row_값이_주어지면_정상적으로_print한다() {
        // Given
        // row가 주어졌을 때 3*3
        Row[] rows = new Row[3];
        for(int i = 0; i < 3; i++) {
            rows[i] = new Row(3);
        }

        LadderRunner ladderRunner = new LadderRunner(rows);
        Position nowPositionY = new Position(0);
        Position nowPositionX = new Position(0);

        // When
        StringBuilder sb =ladderRunner.printLadderLine(LadderPosition.fromCoordinate(nowPositionY,nowPositionX));

        // Then
        String expectedOutput =
                        "0* 0 0 \n" +
                        "0 0 0 \n" +
                        "0 0 0 \n";
        assertEquals(expectedOutput,sb.toString());

    }

}
