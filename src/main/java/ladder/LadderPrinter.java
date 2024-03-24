package ladder;

import java.util.Objects;
import ladder.wrapper.Coordinate;
import ladder.wrapper.Row;

public class LadderPrinter {

    private final Row[] rows;

    public LadderPrinter(Row[] rows) {
        this.rows = rows;
    }

    public void print(Coordinate currentCoordinate) {
        for(int i = 0; i < rows.length; i++) {
            for(int j = 0; j < rows[i].getNodesLength(); j++) {
                printLadder(Coordinate.of(i, j));
                printCurrentLocation(Coordinate.of(i, j), currentCoordinate);
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printLadder(Coordinate coordinate) {
        if(rows[coordinate.getRowIndex()].getNodesDirectionValue(coordinate.getColIndex()) != -1) {
            System.out.print(" ");
        }
        System.out.print(rows[coordinate.getRowIndex()].getNodesDirectionValue(coordinate.getColIndex()));
    }

    public void printCurrentLocation(Coordinate coordinate, Coordinate currnetCoordinate) {
        if(Objects.equals(coordinate, currnetCoordinate)) {
            System.out.print("*");
            return;
        }
        System.out.print(" ");
    }
}
