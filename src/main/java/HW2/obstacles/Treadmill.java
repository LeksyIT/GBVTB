package HW2.obstacles;

import HW2.Obstacles;
import HW2.Participant;

public class Treadmill extends Obstacles {
    private int LENGTH;

    public Treadmill(int COMPLEXITY) {
        super(COMPLEXITY);
        LENGTH = COMPLEXITY;
        setOBSTACLES_NAME("treadmill");
        setACTION("run");
    }

    @Override
    public boolean action(Participant part) {
        return part.running(LENGTH);
    }
}
