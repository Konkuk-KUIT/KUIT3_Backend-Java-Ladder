package ladder;

public class LadderPrinter {

    private final Row[] rows;

    public LadderPrinter(Row[] rows) {
        this.rows = rows;
    }

    public void print(int row, Position position) {
        for(int i = 0; i < rows.length; i++) {
            for(int j = 0; j < rows[i].getNodesLength(); j++) {
                printLadder(i, j);
                printCurrentLocation(i, j, row, position);
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printLadder(int row, int position) {
        if(rows[row].getNodesDirectionValue(position) != -1) {
            System.out.print(" ");
        }
        System.out.print(rows[row].getNodesDirectionValue(position));
    }

    public void printCurrentLocation(int row, int position, int curRow, Position curPos) {
        if(row == curRow && position == curPos.get()) {
            System.out.print("*");
            return;
        }
        System.out.print(" ");
    }
}
