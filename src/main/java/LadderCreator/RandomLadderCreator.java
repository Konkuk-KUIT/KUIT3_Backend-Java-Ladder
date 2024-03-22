package LadderCreator;

import ladder.Row;
import model.LadderPosition;
import model.LadderSize;
import model.NaturalNumber;
import model.Position;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class RandomLadderCreator extends LadderCreator{
    private final LadderSize ls;
    private final Row[] rows;
    Random random = new Random();
    public RandomLadderCreator(LadderSize ls) {
        this.ls = ls;
        rows = new Row[ls.getRow().getNaturalNumber()];
        for(int i = 0; i < rows.length; i++) {
            rows[i] = new Row(ls.getPersons());
        }
        drawlines(generateRandom_xy(ls.getRow(),ls.getPersons()));	// Iterator 사용

    }
    private int numberofRandomLine(){
        return (int) (ls.getPersons().getNaturalNumber()*ls.getRow().getNaturalNumber() * 0.3);
    }
    private HashSet generateRandom_xy(NaturalNumber row, NaturalNumber col){
        HashSet<LadderPosition> xy = new HashSet<>();
        while(xy.size()<numberofRandomLine()) { //유효성 검사 필요 ,,,중복 및 사다리 만족
            int ran_x = random.nextInt(row.getNaturalNumber());
            int ran_y = random.nextInt(col.getNaturalNumber());
            if(ran_y<=row.getNaturalNumber()-2) {
                xy.add(LadderPosition.of(Position.of(ran_x), Position.of(ran_y)));
            }
        }
        return xy;
    }
    public void drawlines(HashSet<LadderPosition> h){
        Iterator iter = h.iterator();
        while(iter.hasNext()) {
            LadderPosition temp_lp= (LadderPosition) iter.next();
            drawLine(temp_lp.getRow(),temp_lp.getRow());
        }
    }
    @Override
    public void drawLine(Position row, Position col) {
        rows[row.getPosition()].drawLine(col);
    }

    @Override
    public Row[] getRows() {
        return rows;
    }

    @Override
    public String createStringLadder(LadderPosition lp) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < rows.length; i++) {
            sb.append(rows[i].createRowString(lp,i)).append('\n');
        }
        return sb.toString();
    }
}
