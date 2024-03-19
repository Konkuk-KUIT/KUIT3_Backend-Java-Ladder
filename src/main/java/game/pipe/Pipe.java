package game.pipe;

import game.pipe.util.PipeStatus;

public class Pipe {

    private PipeStatus pipeStatus;

    public Pipe(){
        this.pipeStatus=PipeStatus.Nothing;
    }

    public void setPipeStatusLeft() {
        this.pipeStatus = PipeStatus.Left;
    }

    public void setPipeStatusRight() {
        this.pipeStatus = PipeStatus.Right;
    }

    public int getMoveWeight(){
        return this.pipeStatus.getWeight();
    }
    public boolean isLeftExtended(){
        return this.pipeStatus.equals(PipeStatus.Left);
    }

    public boolean isRightExtended(){
        return this.pipeStatus.equals(PipeStatus.Right);
    }

}
