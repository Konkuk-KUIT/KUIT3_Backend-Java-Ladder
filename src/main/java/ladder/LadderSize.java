package ladder;

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
}
