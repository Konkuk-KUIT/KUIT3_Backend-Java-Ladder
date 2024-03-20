package game;

import game.field.Field;

public abstract class Game implements Play {

    protected Field field;

    @Override
    public void play() {
        System.out.println("Run Game");
    }
}
