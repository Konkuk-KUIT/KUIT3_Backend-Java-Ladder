package game;

import game.field.Field;

public abstract class Game implements Play {

    protected Field field;

    @Override
    public void play(int...position) {
        System.out.println("Play Game");
    }


    @Override
    public void playWithPrint(int...position) {
        System.out.println("Play Game With Print");
    }
}
