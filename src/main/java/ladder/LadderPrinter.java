package ladder;

import java.util.Objects;

public class LadderPrinter {

    private final Row[] rows;

    public LadderPrinter(Row[] rows) {
        this.rows = rows;
    }

    public void print(Cordinate currentCordinate) {
        for(int i = 0; i < rows.length; i++) {
            for(int j = 0; j < rows[i].getNodesLength(); j++) {
                printLadder(Cordinate.of(i, j));
                printCurrentLocation(Cordinate.of(i, j), currentCordinate);
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printLadder(Cordinate cordinate) {
        if(rows[cordinate.getRowIndex()].getNodesDirectionValue(cordinate.getColIndex()) != -1) {
            System.out.print(" ");
        }
        System.out.print(rows[cordinate.getRowIndex()].getNodesDirectionValue(cordinate.getColIndex()));
    }

    public void printCurrentLocation(Cordinate cordinate, Cordinate currnetCordinate) {
        if(Objects.equals(cordinate, currnetCordinate)) {
            System.out.print("*");
            return;
        }
        System.out.print(" ");
    }
}
