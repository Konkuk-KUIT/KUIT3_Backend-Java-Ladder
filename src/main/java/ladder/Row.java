package ladder;

import model.*;

public class Row {
    private Node[] row;

    public Row(NaturalNumber numberOfPerson) {
        //validateNumberOfPerson(numberOfPerson); NaturalNmber에서 하니깐 생략 가능
        row = new Node[numberOfPerson.getNaturalNumber()];
        for (int i =0; i< numberOfPerson.getNaturalNumber(); i ++){
            row[i]= Node.of(Direction.CENTER);
        }
    }

    public void drawLine(Position lineStartPosition) {
        validateDrawLinePosition(lineStartPosition);
        row[lineStartPosition.getPosition()] = Node.of(Direction.RIGHT);
        row[lineStartPosition.getPosition() + 1] = Node.of(Direction.LEFT);
    }

    public Position nextPosition(Position position) {

        validatePosition(position);

        Position nextPosition = row[position.getPosition()].move(position);

        return nextPosition;
    }
    public String createRowString(LadderPosition lp,int currentRow){
        StringBuilder sb = new StringBuilder();
        for (int i =0; i< row.length; i ++){
            sb.append(row[i].getDirection().getDirect());
            if(currentRow == lp.getCol().getPosition() && i == lp.getRow().getPosition()){
                sb.append('*');
            }
            sb.append(' ');
        }
        return sb.toString();
    }
//    private boolean isLeft(int position) {
//        return row[position] == -1;
//    }
//
//    private boolean isRight(int position) {
//        return row[position] == 1;
//    }

//    private void validateNumberOfPerson(int numberOfPerson) {
//        if(numberOfPerson < 1) {
//            throw new IllegalArgumentException(ExceptionMessage.AT_LEAST_ONE.getExceptionMessage());
//        }
//    }

    private void validateDrawLinePosition(Position lineStartPosition) {
        if(lineStartPosition.getPosition() < 0 || lineStartPosition.getPosition() >= row.length - 1 || row[lineStartPosition.getPosition()].getDirection().getDirect() == -1 || row[lineStartPosition.getPosition() + 1].getDirection().getDirect() == 1) {
            throw new IllegalArgumentException(ExceptionMessage.IMPOSSIBLE_LOCATION_LINE.getExceptionMessage());
        }
    }

    private void validatePosition(Position position) {
        if(position.getPosition() >= row.length || position.getPosition() < 0 ) {
            throw new IllegalArgumentException(ExceptionMessage.NOTVALIDATE_LOCATION.getExceptionMessage());
        }
    }




}
