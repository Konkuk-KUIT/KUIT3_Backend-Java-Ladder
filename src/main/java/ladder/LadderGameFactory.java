package ladder;

public class LadderGameFactory{

    private LadderGame ladderGame;

    public LadderGame createRandomLadderGame(LadderCreator ladderCreator){

        ladderGame = new LadderGame(ladderCreator);

        // 몇개의 선 그을지
        int numberOfLine = ladderCreator.numberOfLine();
        // 선 랜덤하게 긋기 반복문 & 예외처리





        return ladderGame;
    }
}
