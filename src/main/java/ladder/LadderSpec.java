package ladder;

import java.util.Collections;
import java.util.List;

public class LadderSpec {
    private final int row;
    private final int col;
    private List<Integer> startPosition;    // final?

    public LadderSpec(int row, int col, List<Integer> startPosition) {
        this.row = row;
        this.col = col;
        this.startPosition = startPosition;
    }

    public LadderSpec(int row, int col) {
        this.row = row;
        this.col = col;
        this.startPosition = Collections.emptyList();
    }

    private Boolean isRandom() {
        return this.startPosition.isEmpty();
    }


}
