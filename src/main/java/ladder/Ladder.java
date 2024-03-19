//package ladder;
//
//public class Ladder {
//
//    private Row[] rows;
//
//    public Ladder(NaturalNumber numberOfRows, NaturalNumber numberOfPersons) {
//        rows = new Row[numberOfRows.get()];
//
//        for(int i = 0; i < numberOfRows.get(); i++) {
//            rows[i] = new Row(numberOfPersons.get());
//        }
//    }
//
//    public void drawLine(int row, int col) {
//        rows[row].drawLine(col);
//    }
//
//    public Position run(Position startPosition) {
//        Position currentPosition = startPosition;
//
//        for (int i = 0; i < rows.length; i++) {
//            currentPosition = rows[i].nextPosition(currentPosition);
//        }
//
//        return currentPosition;
//    }
//}
