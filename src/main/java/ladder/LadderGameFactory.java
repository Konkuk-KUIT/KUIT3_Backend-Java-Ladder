package ladder;

public class LadderGameFactory {
    public static LadderGame createRandomLadderGame(int numberOfRows, int numberOfPerson) {
        LadderCreator ladderRandomCreator = new RandomLadderCreator();

        return new LadderGame(ladderRandomCreator, numberOfRows, numberOfPerson);
    }


}
