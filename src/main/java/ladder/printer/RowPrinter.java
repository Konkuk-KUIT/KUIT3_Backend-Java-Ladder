package ladder.printer;

import ladder.wrapper.Node;

public class RowPrinter implements Printer {
    private final Node[] row;

    public RowPrinter(Node[] row) {
        this.row = row;
    }

    @Override
    public String print() {
        StringBuilder rowResult = new StringBuilder();
        for (Node node : row) {
            rowResult.append(node.get().get());
            rowResult.append(' ');
        }
        rowResult.append('\n');
        return rowResult.toString();
    }
}
