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


    public void validate() {
        if (numberOfRows < 1 || numberOfPerson < 1) {
            throw new IllegalArgumentException("사다리의 행과 참여자 수는 1명 이상이어야 한다.");
        }
    }
}
