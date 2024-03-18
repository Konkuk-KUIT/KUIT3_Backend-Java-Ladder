package ladder.model;

import static ladder.exception.ExceptionMessage.*;

public class LadderSize {
    private final int numberOfRows;
    private final int numberOfPerson;

    public LadderSize(int numberOfRows, int numberOfPerson) {
        this.numberOfRows = numberOfRows;
        this.numberOfPerson = numberOfPerson;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public int getNumberOfPerson() {
        return numberOfPerson;
    }


    public void validate() {
        if (numberOfRows < 1 || numberOfPerson < 1) {
            throw new IllegalArgumentException(INVALID_PARTICIPANT_COUNT.getMessage());
        }
    }
}
