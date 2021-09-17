package HW2;

import HW2.actions.Jumping;
import HW2.actions.Running;

public abstract class Participant implements Running, Jumping {
    private int MAXIMUM_JUMP_HEIGHT;
    private int MAXIMUM_RUN_LENGTH;
    private String NAME;

    public Participant(int maximum_jump_height, int maximum_run_length, String name) {

        MAXIMUM_JUMP_HEIGHT = maximum_jump_height;
        MAXIMUM_RUN_LENGTH = maximum_run_length;
        NAME = name;
    }


    public int getMAXIMUM_JUMP_HEIGHT() {
        return MAXIMUM_JUMP_HEIGHT;
    }

    public int getMAXIMUM_RUN_LENGTH() {
        return MAXIMUM_RUN_LENGTH;
    }

    public String getNAME() {
        return NAME;
    }
}
