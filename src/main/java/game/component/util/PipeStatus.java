package game.component.util;

public enum PipeStatus {
    Left(PipeConstant.LEFT_DRAW_CONSTANT), Right(PipeConstant.RIGHT_DRAW_CONSTANT), Nothing(PipeConstant.NOTHING);

    private int weight;

    PipeStatus(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
}
