package ladder;

public class LadderSize {
    private final NaturalNumber height;
    private final NaturalNumber width;

    private LadderSize(NaturalNumber height, NaturalNumber width) {
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height.getNumber();
    }
    public int getWidth() {
        return width.getNumber();
    }

    public static LadderSize of(NaturalNumber height, NaturalNumber width) {
        return new LadderSize(height, width);
    }
}
