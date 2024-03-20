package game;

import game.field.Field;

public class LadderGame extends Game{

    public LadderGame(Field field){
        this.field=field;
    }

    @Override
    public void play(int...position) {
        //TODO
        super.play(position);
    }

    @Override
    public void playWithPrint(int...position) {
        field.runWithPrint(position);
    }
}
