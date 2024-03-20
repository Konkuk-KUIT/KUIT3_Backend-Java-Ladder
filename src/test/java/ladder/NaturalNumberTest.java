package ladder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NaturalNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void notNaturalNumberThrowsException(int numbers) {
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            NaturalNumber.from(numbers);
        });

        Assertions.assertEquals(ExceptionMessage.INVALID_NATURAL_NUMBER.getErrorMessage(), exception.getMessage());
    }
}
