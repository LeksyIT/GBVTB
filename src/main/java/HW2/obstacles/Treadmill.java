package HW2.obstacles;

import HW2.Obstacles;
import HW2.Participant;

public class Treadmill extends Obstacles {
    private final int length;

    public Treadmill(int complexity ) {
        length = complexity;
        setOBSTACLES_NAME("treadmill");
        setACTION("run");
    }

    @Override
    public boolean action(Participant part) {
        return part.running(length);
    }
}
