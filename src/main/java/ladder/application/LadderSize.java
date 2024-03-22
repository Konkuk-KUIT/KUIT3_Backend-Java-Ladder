package ladder.application;

import ladder.core.NaturalNumber;

public class LadderSize {
    NaturalNumber width;
    NaturalNumber height;

    private LadderSize(NaturalNumber width, NaturalNumber height) {
        this.width = width;
        this.height = height;
    }

    public static LadderSize of(NaturalNumber width, NaturalNumber height){
        return new LadderSize(width, height);
    }

    public int getHeight() {
        return height.get();
    }

    public int getWidth() {
        return width.get();
    }
}
