package hw2;

import hw2.actions.Jumping;
import hw2.actions.Running;

public abstract class Participant implements Running, Jumping {
    private int maximumJumpHeight;
    private int maximumRunLength;
    private String name;

    public Participant(int maximumJumpHeight, int maximumRunLength, String name) {

        this.maximumJumpHeight = maximumJumpHeight;
        this.maximumRunLength = maximumRunLength;
        this.name = name;
    }


    public int getMAXIMUM_JUMP_HEIGHT() {
        return maximumJumpHeight;
    }

    public int getMAXIMUM_RUN_LENGTH() {
        return maximumRunLength;
    }

    public String getNAME() {
        return name;
    }
}
