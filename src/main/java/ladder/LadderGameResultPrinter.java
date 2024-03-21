package ladder;

public class LadderGameResultPrinter implements Printer {
    private String gameResult;

    public LadderGameResultPrinter() {
        gameResult = "";
    }

    public void write(String gameResult) {
        this.gameResult = gameResult;
    }

    @Override
    public String print() {
        return gameResult;
    }
}
