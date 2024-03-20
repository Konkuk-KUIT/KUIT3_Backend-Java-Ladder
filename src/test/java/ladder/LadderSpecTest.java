package ladder;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LadderSpecTest {
    @ParameterizedTest
    @CsvSource({"5, 1, 4", "2, 6, 9"})
    @DisplayName("유효하지 않은 세로줄이 들어왔을 떄의 예외처리")
    void invalidColLineThrowsException(int row1, int pos, int row2) {
        // given
        NaturalNumber numberOfRows = NaturalNumber.from(4);
        NaturalNumber numberOfPerson = NaturalNumber.from(4);
        List<SideLadder> sideLadders = List.of(new SideLadder(row1, Position.initOf(pos,NaturalNumber.from(row2))));

        // when, then
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    new LadderSpec(numberOfRows, numberOfPerson, sideLadders);
                });
        Assertions.assertEquals(exception.getMessage(), ExceptionMessage.INVALID_SIDE_LADDER.getErrorMessage());
    }
}
