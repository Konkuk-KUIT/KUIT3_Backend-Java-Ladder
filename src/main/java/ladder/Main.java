package ladder;

public class Main {
    public static void main(String[] args) {
        Ladder ladder = new Ladder(5, 5); // 5줄의 사다리와 5명의 참여자
        ladder.drawLine(0, 1); // 첫 번째 줄에 1번 위치에 선을 그음
        ladder.drawLine(2, 2); // 세 번째 줄에 2번 위치에 선을 그음
        ladder.drawLine(4, 0); // 다섯 번째 줄에 0번 위치에 선을 그음

    }
}
