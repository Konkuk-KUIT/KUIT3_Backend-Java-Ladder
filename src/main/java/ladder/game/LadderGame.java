package ladder.game;

import ladder.LadderRunner;
import ladder.Position;
import ladder.creator.LadderCreator;
import view.InputView;
import view.OutputView;

public class LadderGame {
    private final LadderCreator ladderCreator;
    private final OutputView outputView;
    private final InputView inputView;
    public LadderGame(LadderCreator ladderCreator,OutputView outputView, InputView inputView){
        this.ladderCreator = ladderCreator;
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void play(){


        // 여기에 어느 곳에 선을 그을지 확인
        ladderCreator.drawLine(0,1);
        ladderCreator.drawLine(1,1);

        // 원하는 번호 입력
        outputView.printSelectNumber();
//        int number = inputView.readLadderNumber();
        int number = 1;

        // runner로 돌리기
        LadderRunner ladderRunner = new LadderRunner(ladderCreator.getRows());
        Position position = new Position(number);
        int destination = ladderRunner.run(position);
        System.out.println("도착지는?");
        System.out.println(destination);
    }
}
