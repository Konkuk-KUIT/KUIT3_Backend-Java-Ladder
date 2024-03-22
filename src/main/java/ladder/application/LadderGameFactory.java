package ladder.application;

import ladder.creater.CustomLadderCreator;
import ladder.creater.RandomLadderCreator;

public class LadderGameFactory {

    // 랜덤게임 만들기
    public static RandomLadderCreator randomLadderCreator(LadderSize ladderSize) {
        RandomLadderCreator randomLadderCreator = new RandomLadderCreator(ladderSize);
        return randomLadderCreator;
    }

    // 고전게임 만들기
    public static CustomLadderCreator customLadderCreator(LadderSize ladderSize) {
        CustomLadderCreator customLadderCreator = new CustomLadderCreator(ladderSize);
        return customLadderCreator;
    }
}
