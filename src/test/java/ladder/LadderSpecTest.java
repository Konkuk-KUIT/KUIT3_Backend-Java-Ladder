package ladder;

import java.util.List;
import ladder.exception.ExceptionMessage;
import ladder.wrapper.Coordinate;
import ladder.wrapper.LadderSpec;
import ladder.wrapper.NaturalNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
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
        List<Coordinate> sideLadders = List.of(Coordinate.of(row1, pos));

        // when, then
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    new LadderSpec(numberOfRows, numberOfPerson, sideLadders);
                });
        Assertions.assertEquals(exception.getMessage(), ExceptionMessage.INVALID_SIDE_LADDER.getErrorMessage());
    }

    @ParameterizedTest
    @CsvSource({"2, 2", "2, 3"})
    @DisplayName("겹치는 사다리가 생성된 경우 예외처리 테스트")
    void DuplicatedSideLadder(int row, int position) {
        // given
        NaturalNumber numberOfRows = NaturalNumber.from(4);
        NaturalNumber numberOfPerson = NaturalNumber.from(4);
        Coordinate sideLadder1 = Coordinate.of(2, 2);
        Coordinate sideLadder2 = Coordinate.of(row, position);
        List<Coordinate> sideLadders = List.of(sideLadder1, sideLadder2);

        // when, then
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new LadderSpec(numberOfRows, numberOfPerson, sideLadders);
        });

        Assertions.assertEquals(exception.getMessage(), ExceptionMessage.INVALID_SIDE_LADDER.getErrorMessage());
    }
}
