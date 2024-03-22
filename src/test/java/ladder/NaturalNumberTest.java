package ladder;

import ladder.exception.ExceptionMessage;
import ladder.wrapper.NaturalNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NaturalNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    @DisplayName("자연수가 아닐 떄의 예외 처리")
    void notNaturalNumberThrowsException(int numbers) {
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            NaturalNumber.from(numbers);
        });

        Assertions.assertEquals(ExceptionMessage.INVALID_NATURAL_NUMBER.getErrorMessage(), exception.getMessage());
    }
}
