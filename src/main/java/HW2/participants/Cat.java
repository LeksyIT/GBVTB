package HW2.participants;

import HW2.Participant;
import HW2.actions.Jumping;
import HW2.actions.Running;

public class Cat extends Participant implements Jumping, Running {
    public Cat(int maximum_jump_height, int maximum_run_length, String name) {
        super(maximum_jump_height, maximum_run_length, name);
    }

    @Override
    public boolean jumping(int height) {
        return getMAXIMUM_JUMP_HEIGHT() >= height;
    }

    @Override
    public boolean running(int length) {
        return getMAXIMUM_RUN_LENGTH() >= length;
    }
}
