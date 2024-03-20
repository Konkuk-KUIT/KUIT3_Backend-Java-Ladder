package ladder;

public class LadderGameFactory {
    public static LadderGame createRandomLadderGame(NaturalNumber numberOfRows, NaturalNumber numberOfPerson) {
        LadderCreator ladderRandomCreator = new RandomLadderCreator();

        return new LadderGame(ladderRandomCreator, numberOfRows, numberOfPerson);
    }
}
