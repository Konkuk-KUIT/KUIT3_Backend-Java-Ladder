package model;

public class LadderSize {
    private final NaturalNumber row;
    private final NaturalNumber persons;


    public LadderSize(NaturalNumber row, NaturalNumber persons) {
        this.row = row;
        this.persons = persons;
    }
    public static LadderSize of(NaturalNumber row, NaturalNumber persons){
        LadderSize ls = new LadderSize(row,persons);
        return ls;
    }
    public static LadderSize InttoLadderSize(int row, int persons){
        LadderSize ls = new LadderSize(NaturalNumber.of(row),NaturalNumber.of(persons));
        return ls;
    }
    public NaturalNumber getRow(){
        return row;
    }
    public NaturalNumber getPersons(){
        return persons;
    }
}
