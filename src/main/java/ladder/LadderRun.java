package ladder;

public class LadderRun {

    private Row[] rows;
    public LadderRun(Row[] rows) {
        this.rows = rows;
    }


    public int run(Position position){
        validationStartPosition(position);
        System.out.println("게임 시작");
        for(int i = 0; i < rows.length - 1; i++) {
            printBefore(Position.of(i), position);
            position = rows[i].nextPosition(position);
            printAfter(Position.of(i), position);
        }

        return position.getValue();
    }

    private void printBefore(Position row, Position position) {
        System.out.println("Before");
        for(int i = 0; i < rows.length; i++) {
            if (i == row.getValue()){
                rows[i].printNode(true, position);
            } else {
                rows[i].printNode(false, position);
            }
        }
        System.out.println();
    }

    private void printAfter(Position row, Position position) {
        System.out.println("After");
        for(int i = 0; i < rows.length; i++) {
            if (i == row.getValue()){
                rows[i].printNode(true, position);
            } else {
                rows[i].printNode(false, position);
            }
        }
        System.out.println();
    }



    private void validationStartPosition(Position position) {
        if(position.getValue() >= rows.length || position.getValue() < 0){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_POISTION_START.getExceptionMessage());
        }
    }
}
