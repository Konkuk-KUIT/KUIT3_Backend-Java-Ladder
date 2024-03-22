//package ladder;
//
//public class Ladder {
//
//    private Row[] rows;
//
//    public Ladder(NaturalNumber numberOfRows, NaturalNumber numberOfPerson) {
//        rows = new Row[numberOfPerson.getNum()];
//
//        for(int i = 0; i < numberOfRows.getNum(); i++) {
//            rows[i] = new Row(numberOfPerson);
//        }
//    }
//
//    public void drawLine(Position row, Position col) {
//        rows[row.getPosition()].drawLine(Position.of(col.getPosition()));
//    }
//
//    public int run(Position position) {
//
//        for(int i = 0; i < rows.length; i++) {
//            position = rows[i].nextPosition(position);
//        }
//
//        return position.getPosition();
//    }
//}
